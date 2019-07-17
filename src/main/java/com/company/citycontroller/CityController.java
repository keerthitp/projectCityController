package com.company.citycontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {
    List<City> cityList;

    public CityController() {
        cityList = new ArrayList<>();
        cityList.add(new City("Nairobi", "Kenya", 3.14, true));
        cityList.add(new City("Seattle", "Washington", 1.1, true));
        cityList.add(new City("Dallas", "Texas", 1.3, true));
        cityList.add(new City("San Diego", "California", 2.2, true));
        cityList.add(new City("Baltimore", "Marylad", 1.62, true));

    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    public City getCityByName(@PathVariable String name) {
        for (int x = 0; x < this.cityList.size(); x++) {
            if (this.cityList.get(x).getName().equals(name)) {
                return cityList.get(x);
            }
        }
        return null;
    }


    @RequestMapping(value = "/city/population/{population}", method = RequestMethod.GET)
    public List<City> getCityByPopulation(@PathVariable @NotBlank @Min(1) double population) {
        List<City> matches = new ArrayList<>();
        for (int x = 0; x < this.cityList.size(); x++) {
            if (this.cityList.get(x).getPopulation()>(population)) {
                matches.add(cityList.get(x));
            }
        }
        return matches;
    }



    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public List<City> getCity(){
        return this.cityList;
    }
// Adding
        @RequestMapping(value = "/city", method = RequestMethod.POST)
        public City createdCity(@RequestBody City city) throws IllegalArgumentException{
            if(!Character.isUpperCase(city.getName().charAt(0))) {
                throw new IllegalArgumentException("Please enter the city with a capitol letter");
            }
            if (!Character.isUpperCase(city.getState().charAt(0))){
                throw new IllegalArgumentException("Please enter the state with a capitol letter");
            }
            if(city.getPopulation() <= 0){
                throw new IllegalArgumentException("Please enter population greater then zero");
            }
            cityList.add(city);
            return city;


    }
    // Retrieve all cities by state
    @RequestMapping(value = "/city/state/{state}", method = RequestMethod.GET)
    public List<City> getCityByState(@PathVariable String state){

        List<City> cityListByState = new ArrayList<>();
        for (int i = 0; i< cityList.size(); i++){
            if (cityList.get(i).getState().toLowerCase().equals(state.toLowerCase())){
                cityListByState.add(cityList.get(i));
            }
        }

        return cityListByState;
    }

    //Deleting
    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable String name) {
        for (int i = 0; i < this.cityList.size(); i++) {
            if (this.cityList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                this.cityList.remove(i);
                break;
            }
        }
    }



}
