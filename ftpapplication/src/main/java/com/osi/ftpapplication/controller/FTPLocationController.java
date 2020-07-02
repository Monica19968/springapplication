package com.osi.ftpapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osi.ftpapplication.exception.FTPLocationNotFoundException;
import com.osi.ftpapplication.model.FTPLocation;
import com.osi.ftpapplication.service.FTPLocationService;

@RestController
@RequestMapping("/ftpLocation")
public class FTPLocationController {

	@Autowired
	FTPLocationService ftpLocationService;
	/**
	 *For Creating FTP Location 
	 * @param ftpLocation
	 * @return All Created FTP Locations
	 */
	@PostMapping("/createFTPLocation")
	public String createFTPLocation(@Valid @RequestBody FTPLocation ftpLocation) {
		return ftpLocationService.createFTPLocation(ftpLocation);
	}
	
	/**
	 * Fetch FTPLocation by userName
	 * @param userName
	 * @return FTPLocation by userName with all fields
	 */
	@GetMapping("/getFTPLocation/{userName}")
	public FTPLocation getFTPLocation(@PathVariable String userName) {
		return ftpLocationService.getFTPLocation(userName);
	}

	/**
	 * Updating existing FTPLocation by id
	 * @param ftpID
	 * @param ftpLocation
	 * @return Updated FTP location
	 * @throws FTPLocationNotFoundException
	 */
	@PatchMapping("/updateFTPLocation/{id}")
	public FTPLocation updateFTPLocation(@PathVariable("id") Integer ftpID, @RequestBody FTPLocation ftpLocation)
			throws FTPLocationNotFoundException {
		return ftpLocationService.updateFTPLocation(ftpID, ftpLocation);
	}

	/**
	 * Fetch all FTP Locations
	 * @return All FTPLocations
	 */
	@GetMapping("/getAllFTPLocation")
	public List<FTPLocation> getAllFTPLocation(){
		return ftpLocationService.getAllFTPLocation();
	}
	/**
	 * Delete FTPLocation by id
	 * @param id
	 * @return successfully deleted FTPLocation
	 */
	@DeleteMapping("/deleteFTPLocation/{id}")
	public FTPLocation deleteFTPLocation(@PathVariable Integer id) {
		return ftpLocationService.deleteFTPLocation(id);
	}
	
	@GetMapping("/getFiles")
	public List getAllFiles() {
		return ftpLocationService.getFilesFTPFromServer();
	}
	
	 @GetMapping("/copyfiles")
	  public String copyingFile(@RequestParam(value="source") String source, @RequestParam(value="dest")String dest) throws IOException {
	      ftpLocationService.copyingFile(source, dest);
	     return "file transfer was successful";
	      }
	
	
}
