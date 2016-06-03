package com.euretos.brain;

import java.util.ArrayList;
import java.util.Set;

public class UuidsInput {
	
	private ArrayList<String> uids = new ArrayList<String>(); 

	public UuidsInput(String tripleUuid) {
		this.uids.add(tripleUuid);
	}

	public UuidsInput(Set<String> tripleUuids) {
		this.uids.addAll(tripleUuids);
	}
}
