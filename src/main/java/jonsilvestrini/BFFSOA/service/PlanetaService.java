package jonsilvestrini.BFFSOA.service;

import java.util.ArrayList;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jonsilvestrini.BFFSOA.dto.response.PlanetaDetalheDTO;
import jonsilvestrini.BFFSOA.dto.response.planetas.Ascensao;
import jonsilvestrini.BFFSOA.dto.response.planetas.Clima;
import jonsilvestrini.BFFSOA.dto.response.planetas.CorposCeleste;
import jonsilvestrini.BFFSOA.dto.response.planetas.Declinacao;
import jonsilvestrini.BFFSOA.dto.response.planetas.PlanetaVisivelResponseDTO;
import jonsilvestrini.BFFSOA.exception.InternalServerException;
import jonsilvestrini.BFFSOA.external.WebClientEngine;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PlanetaService {

	private final WebClientEngine webEngine = new WebClientEngine();

	@Value("${geoloc.url}")
	private String geoLocURL;

	@Value("${geoloc.key}")
	private String geoLocKey;

	@Value("${clima.url}")
	private String climaURL;

	@Value("${clima.key}")
	private String climaKey;

	@Value("${plavisiveis.url}")
	private String planVisiveisURL;

	@Value("${wikipedia.url}")
	private String wikipediaUrl;

	public PlanetaVisivelResponseDTO getPlanetaVisivel(HttpServletRequest request) {
		try {
			String ip = request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") ? "177.21.198.195" : request.getRemoteAddr();

			log.info(ip);

			PlanetaVisivelResponseDTO planetaVisivelDTO = new PlanetaVisivelResponseDTO();
			String geoLocUrlAsm = String.format("%s?ip=%s&apiKey=%s", geoLocURL, ip, geoLocKey);
			JSONObject geoLocResp = new JSONObject(webEngine.callUrlSync(geoLocUrlAsm));

			Double lat = geoLocResp.getJSONObject("location").getDouble("latitude");
			Double lon = geoLocResp.getJSONObject("location").getDouble("longitude");

			String climaUrlAsm = String.format("%s?lat=%s&lon=%s&appid=%s", climaURL, lat, lon, climaKey);
			String planVisiveisURLAsm = String.format("%s?latitude=%s&longitude=%s", planVisiveisURL, lat, lon);

			Future<String> strClimaResp = webEngine.callUrlAsync(climaUrlAsm);
			Future<String> strPlanVisResp = webEngine.callUrlAsync(planVisiveisURLAsm);

			JSONObject climaResp = new JSONObject(strClimaResp.get());
			JSONObject planVisResp = new JSONObject(strPlanVisResp.get());

			planetaVisivelDTO.setCorposCelestes(new ArrayList<CorposCeleste>());

			for (Object objCeleste : planVisResp.getJSONArray("data")) {
				JSONObject obj = (JSONObject) objCeleste;
				planetaVisivelDTO.getCorposCelestes().add(
						CorposCeleste.builder()
							.nome(obj.getString("name"))
							.constelacao(obj.getString("constellation"))
							.ascensao(Ascensao.builder()
									.horas(obj.getJSONObject("rightAscension").getInt("hours"))
									.minutos(obj.getJSONObject("rightAscension").getInt("minutes"))
									.segundos(obj.getJSONObject("rightAscension").getDouble("seconds"))
									.negativo(obj.getJSONObject("rightAscension").getBoolean("negative"))
									.build())
							.declinacao(Declinacao.builder()
									.grau(obj.getJSONObject("declination").getInt("degrees"))
									.minutos(obj.getJSONObject("declination").getInt("arcminutes"))
									.segundos(obj.getJSONObject("declination").getInt("arcseconds"))
									.negativo(obj.getJSONObject("declination").getBoolean("negative"))
									.build())
							.acimaHorizonte(obj.getBoolean("aboveHorizon"))
							.visivelOlhoNu(obj.getBoolean("nakedEyeObject"))
							.build()
						);

			}

			JSONObject objCeu = (JSONObject) climaResp.getJSONArray("weather").get(0);

			planetaVisivelDTO.setClima(
						Clima.builder()
							.ceu(objCeu.getString("description"))
							.visibilidade(climaResp.getInt("visibility"))
							.nuvens(climaResp.getJSONObject("clouds").getInt("all"))
							.build()
					);

			return planetaVisivelDTO;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public PlanetaDetalheDTO getPlanetaDetalhe(String name) {
		String wikiUrlAsm;

		if (name.equals("Mercury"))
			return PlanetaDetalheDTO.builder()
					.nome("Mercury (planet)")
					.descricao("Mercury is the smallest planet in the Solar System and the closest to the Sun. Its orbit around the Sun takes 87.97 Earth days, the shortest of all the Sun's planets. It is named after the Roman god Mercuriuscode: lat promoted to code: la  (Mercury), god of commerce, messenger of the gods, and mediator between gods and mortals, corresponding to the Greek god Hermes. Like Venus, Mercury orbits the Sun within Earth's orbit as an inferior planet, and its apparent distance from the Sun as viewed from Earth never exceeds 28°. This proximity to the Sun means the planet can only be seen near the western horizon after sunset or the eastern horizon before sunrise, usually in twilight. At this time, it may appear as a bright star-like object, but is more difficult to observe than Venus. From Earth, the planet telescopically displays the complete range of phases, similar to Venus and the Moon, which recurs over its synodic period of approximately 116 days. The synodic proximity of Mercury to Earth makes Mercury most of the time Earth's closest planet, despite Venus at times approaching Earth closer than any other planet can.")
					.urlImagem("https://upload.wikimedia.org/wikipedia/commons/4/4a/Mercury_in_true_color.jpg")
					.build();

		wikiUrlAsm = String.format("%s/%s", wikipediaUrl, name);

		String json = webEngine.callUrlSync(wikiUrlAsm);
		JSONObject wikiResp = new JSONObject(json);
		return PlanetaDetalheDTO.builder()
				.nome(wikiResp.getString("title"))
				.descricao(wikiResp.getString("extract"))
				.urlImagem(wikiResp.getJSONObject("originalimage").getString("source"))
				.build();
	}



}
