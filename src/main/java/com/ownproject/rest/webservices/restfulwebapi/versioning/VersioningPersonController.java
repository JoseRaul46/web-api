package com.ownproject.rest.webservices.restfulwebapi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Adam");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Lopez", "Martinez"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("miguel");
    }

    @GetMapping(value = "/person", params = {"version=3","id"})
    public PersonV2 getThirdVersionOfPersonRequestParameter(@RequestParam String version, @RequestParam String id){
        return new PersonV2(new Name(version, id));
    }

    @GetMapping(value = "/person", params = {"version=4","id"})
    public PersonV2 getFourthVersionOfPersonRequestParameter(@RequestParam String version, @RequestParam String id){
        return new PersonV2(new Name(version, "miguel"));
    }

    @GetMapping(value = "/person/headers", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeaders(){
        return new PersonV1("miguel Header");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeaders(){
        return new PersonV1("miguel Header accepts");
    }
}
