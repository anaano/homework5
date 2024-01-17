package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public City getCity(AddCity addCity) {
        City city = cityRepository.findOneByCity(addCity.getCity());
        if (city != null) {
            return  city;
        }
        city = new City();
        city.setCity_id(city.getCity_id());
        city.setCity(city.getCity());

        return cityRepository.save(city);
    }
}
