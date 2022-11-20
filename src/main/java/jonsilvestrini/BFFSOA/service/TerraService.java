package jonsilvestrini.BFFSOA.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jonsilvestrini.BFFSOA.dto.response.terra.Coord;
import jonsilvestrini.BFFSOA.dto.response.terra.TerraImagemDTO;
import jonsilvestrini.BFFSOA.exception.NotFoundException;
import jonsilvestrini.BFFSOA.external.WebClientEngine;

@Service
public class TerraService {
	private final WebClientEngine webEngine = new WebClientEngine();

	@Value("${terra.api.url}")
	private String terraApiUrl;

	@Value("${terra.img.url}")
	private String terraImgUrl;

	public List<TerraImagemDTO> getTerraImages(String date) {
		String terraUrlAsm = String.format("%s/%s", terraApiUrl, date);
		JSONArray arrayTerraImg = new JSONArray(webEngine.callUrlSync(terraUrlAsm));

		if (arrayTerraImg.isEmpty()) {
			throw new NotFoundException();
		}

		List<TerraImagemDTO> listTerraImg = new ArrayList<TerraImagemDTO>();

		for (Object imgTerra : arrayTerraImg) {
			if (imgTerra == null)
				continue;

			JSONObject imgTerraObj = (JSONObject) imgTerra;

			String urlImg = String.format("%s/%s/png/%s.png", terraImgUrl, date.replace("-", "/"),
					imgTerraObj.getString("image"));

			listTerraImg.add(TerraImagemDTO.builder().dateTime(imgTerraObj.getString("date")).urlImage(urlImg)
					.coord(Coord.builder()
							.lat(imgTerraObj.getJSONObject("coords").getJSONObject("centroid_coordinates")
									.getDouble("lat"))
							.lon(imgTerraObj.getJSONObject("coords").getJSONObject("centroid_coordinates")
									.getDouble("lon"))
							.build())
					.build());

		}

		return listTerraImg;
	}

}
