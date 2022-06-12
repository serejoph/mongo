package projetomongo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;

import projetomongo.model.Localizacao;

@Service
public class LocalizacaoService {

	public Double[] getLatLong(Localizacao localizacao) throws ApiException, InterruptedException, IOException {
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyA86peBVMtJ2syhRWWbDiVp1ttbdRyCAw0").build();
		GeocodingApiRequest request = GeocodingApi.newRequest(context).address(localizacao.getEndereco());
		LatLng latLng = request.await()[0].geometry.location;
		return new Double[] { latLng.lat, latLng.lng };

	}

}
