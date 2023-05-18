package com.ownproject.rest.webservices.restfulwebapi.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class filteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3", "new4","5","6");
        MappingJacksonValue mappingJacksonValue =  setMappingFiltering(Arrays.asList("field5", "field3"), Collections.singletonList(someBean));

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1", "value2", "value3", "new4", "5", "6"),
                new SomeBean("value4", "value5", "value6", "new4", "5", "6"),
                new SomeBean("value7", "value8", "value9", "new4", "5", "6"));

        MappingJacksonValue mappingJacksonValue = setMappingFiltering(Arrays.asList("field3", "field6"), someBeans);

        return mappingJacksonValue;
    }

    private MappingJacksonValue setMappingFiltering(List<String> values, List<SomeBean> list){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(new HashSet<>(values));
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
