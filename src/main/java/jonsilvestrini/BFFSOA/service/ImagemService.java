package jonsilvestrini.BFFSOA.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jonsilvestrini.BFFSOA.dto.response.ImagemAleatoriaDTO;
import jonsilvestrini.BFFSOA.external.WebClientEngine;

@Service
public class ImagemService {
	private final WebClientEngine webEngine = new WebClientEngine();

	@Value("${nasa.img.url}")
	private String nasaImgUrl;

	@Value("${nasa.img.key}")
	private String nasaImgKey;

	public ImagemAleatoriaDTO getImagem() {
		String nasaImgUrlAsm = String.format("%s?api_key=%s&count=1",
				nasaImgUrl,
				nasaImgKey);

		JSONArray arrayNasaImg = new JSONArray(webEngine.callUrlSync(nasaImgUrlAsm));

		JSONObject nasaImg = (JSONObject) arrayNasaImg.get(0);

		return ImagemAleatoriaDTO.builder()
				.titulo(nasaImg.getString("title"))
				.explicacao(nasaImg.getString("explanation"))
				.data(nasaImg.getString("date"))
				.urlImagem(nasaImg.getString("hdurl"))
				.build();


	}

}
