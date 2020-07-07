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

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.osi.ftpapplication.exception.FTPLocationNotFoundException;
import com.osi.ftpapplication.model.FTPLocation;

import com.osi.ftpapplication.service.FTPLocationService;

@RestController
@RequestMapping("/ftpLocation")
public class FTPLocationController {

	@Autowired
	FTPLocationService ftpLocationService;

	/**
	 * For Creating FTP Location
	 * 
	 * @param ftpLocation
	 * @return All Created FTP Locations
	 */
	/// From UI, PostMan
	@PostMapping("/createFTPLocation")
	public String createFTPLocation(@Valid @RequestBody FTPLocation ftpLocation) {
		return ftpLocationService.createFTPLocation(ftpLocation);
	}

	/**
	 * Fetch FTPLocation by userName
	 * 
	 * @param userName
	 * @return FTPLocation by userName with all fields
	 */
	
	@GetMapping("/getFTPLocation/{locationName}")
	/// From UI, PostMan
	public FTPLocation getFTPLocation(@PathVariable String locationName) {
		return ftpLocationService.getFTPLocation(locationName);
	}
	
	/**
	 * Fetch FTPLocation by id
	 * 
	 * @param id
	 * @return FTPLocation by id with all fields
	 */
	// From UI, PostMan
   @GetMapping("/getFTPLocation/{id}")
   public FTPLocation getFTPLocation(@PathVariable Integer id) {
	return ftpLocationService.getFTPLocation(id);
	   
   }
	/**
	 * Updating existing FTPLocation by id
	 * 
	 * @param ftpID
	 * @param ftpLocation
	 * @return Updated FTP location
	 * @throws FTPLocationNotFoundException
	 */
	/// From UI, PostMan
	@PatchMapping("/updateFTPLocation/{id}")
	public FTPLocation updateFTPLocation(@PathVariable("id") Integer ftpID, @RequestBody FTPLocation ftpLocation)
			throws FTPLocationNotFoundException {
		return ftpLocationService.updateFTPLocation(ftpID, ftpLocation);
	}

	/**
	 * Fetch all FTP Locations
	 * 
	 * @return All FTPLocations
	 */
	/// From UI, PostMan
	@GetMapping("/getAllFTPLocation")
	public List<FTPLocation> getAllFTPLocation() {
		return ftpLocationService.getAllFTPLocation();
	}

	/**
	 * Delete FTPLocation by id
	 * 
	 * @param id
	 * @return successfully deleted FTPLocation
	 */
	@DeleteMapping("/deleteFTPLocation/{id}")
	/// From UI, PostMan
	public FTPLocation deleteFTPLocation(@PathVariable Integer id) {
		return ftpLocationService.deleteFTPLocation(id);
	}

	
	/// From PostMan
	@GetMapping("/getFilesInLocation")
	public List getFilesInLocation(@PathVariable Integer locationId ) {
		return null;
	}
	
	

		//From postman
//	@GetMapping("/copyFiles/{id}")
//	public String copyFile(@PathVariable Integer id, 
//			@RequestParam String sourceInputStream,
//			@RequestParam String destInputStream ) throws IOException, SftpException {
//		ftpLocationService.copyFile(id, sourceInputStream, destInputStream);
//		return "file copied succesfully";
//		
//	}
	/// From PostMan
	@GetMapping("/copyFiles")
		public boolean copyFiles( 
				@RequestParam(value = "sourceID") Integer sourceID,
				@RequestParam(value = "destLocationID") Integer destID) 
						throws IOException {
		return ftpLocationService.copyFiles(sourceID, destID);
		}
			
}
