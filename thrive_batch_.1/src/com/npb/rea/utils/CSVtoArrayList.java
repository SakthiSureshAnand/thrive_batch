package com.npb.rea.utils;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVtoArrayList {

	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> convertCSVtoArrayList(String dataCSV) {
		System.out.println("CSV ARRAY LIST ()");
		ArrayList<String> arraylistResult = new ArrayList<String>();

		if (dataCSV != null) {
			String[] splitData = dataCSV.split(",",-1);
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					arraylistResult.add(splitData[i]);
				}
			}
		}

		return arraylistResult;
	}

}
