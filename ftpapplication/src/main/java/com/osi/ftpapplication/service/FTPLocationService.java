package com.osi.ftpapplication.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.osi.ftpapplication.exception.FTPLocationNotFoundException;
import com.osi.ftpapplication.model.FTPLocation;

import com.osi.ftpapplication.repository.FTPLocationRepository;

@Service
public class FTPLocationService {

	@Autowired
	FTPLocation properties;
	@Autowired
	FTPLocationRepository ftpLocationRepository;

	public String createFTPLocation(FTPLocation ftpLocation) {
		FTPLocation savedFTPLocation = ftpLocationRepository.save(ftpLocation);
		if (savedFTPLocation != null)
			return "Your FTPLoaction is saved " + ftpLocation.getUserName();
		else
			return "Your FTPLoaction isn't saved " + ftpLocation.getUserName();
	}

	public FTPLocation getFTPLocation(String userName) {
		return ftpLocationRepository.getByUserName(userName);
	}

	public FTPLocation updateFTPLocation(Integer id, FTPLocation ftpLocation) throws FTPLocationNotFoundException {
		if (!ftpLocationRepository.existsById(id)) {
			throw new FTPLocationNotFoundException("FTP doesn't exist " + id);
		}
		FTPLocation updatedFTPLocation = new FTPLocation();
		updatedFTPLocation.setId(id);
		updatedFTPLocation.setLocationUrl(ftpLocation.getLocationUrl());
		updatedFTPLocation.setLocationName(ftpLocation.getLocationName());
		updatedFTPLocation.setUserName(ftpLocation.getUserName());
		updatedFTPLocation.setPassword(ftpLocation.getPassword());
		return ftpLocationRepository.save(updatedFTPLocation);
	}

	public List<FTPLocation> getAllFTPLocation() {
		List<FTPLocation> AllFTPLocation = null;
		AllFTPLocation = ftpLocationRepository.findAll();
		return AllFTPLocation;
	}

	public FTPLocation deleteFTPLocation(Integer id) {
		ftpLocationRepository.deleteById(id);
		return null;
	}

	public void isValidLocation() {
		FTPLocation ftpLocation = new FTPLocation();
		if (ftpLocation != null) {

		}
	}

	public List getFilesFTPFromServer() {

		String SFTPWORKINGDIR = "/home/trainer/";

		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		List someDataList = new Vector<>();

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(properties.getUserName(), properties.getServer(), properties.getPort());
			session.setPassword(properties.getPassword());
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(SFTPWORKINGDIR);
			Vector filelist = channelSftp.ls(SFTPWORKINGDIR);
			for (int i = 0; i < filelist.size(); i++) {
				// System.out.println(filelist.get(i).toString());
				someDataList.add(filelist.get(i).toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return someDataList;
	}

	public void copyingFile(String source, String dest) {
		JSch jsch = new JSch();
		Session session = null;
		try {

			session = jsch.getSession(properties.getUserName(), properties.getServer(), properties.getPort());
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(properties.getPassword());
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;

			InputStream bis = sftpChannel.get(source);

			BufferedReader br = new BufferedReader(new InputStreamReader(bis));

			String temp;
			while ((temp = br.readLine()) != null) {
				InputStream tempStream = new ByteArrayInputStream(temp.getBytes());
				sftpChannel.put(tempStream, dest, 1);
			}

			sftpChannel.disconnect();
			sftpChannel.exit();
			session.disconnect();
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
