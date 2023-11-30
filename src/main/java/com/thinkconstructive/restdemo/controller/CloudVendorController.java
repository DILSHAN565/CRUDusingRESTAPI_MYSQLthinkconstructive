package com.thinkconstructive.restdemo.controller;

import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {


    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }



    @GetMapping("{vendorId}") // Added curly braces to specify the path variable
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        // Corrected the constructor call by removing incorrect syntax
        return cloudVendorService.getCloudVendor(vendorId);
        //new CloudVendor("C1", "Vendor1", "Address1", "xxxx");
    }



    //get all vendors


    @GetMapping() // Added curly braces to specify the path variable
    public List<CloudVendor> getAllCloudVendorDetails() {
        // Corrected the constructor call by removing incorrect syntax
        return cloudVendorService.getAllCloudVendors();
        //new CloudVendor("C1", "Vendor1", "Address1", "xxxx");
    }





    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
    }
}
