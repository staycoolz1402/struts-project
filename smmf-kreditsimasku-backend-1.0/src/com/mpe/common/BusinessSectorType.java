package com.mpe.common;

public enum BusinessSectorType {
	GROUP,
	SECTOR,
	SUBSECTOR,
	SUBSECTOR1,
	SUBSECTOR2;
	
	public static BusinessSectorType byOrdinal(int ordinal) {
		switch(ordinal) {
		case 0:
			return GROUP;
		case 1:
			return SECTOR;
		case 2:
			return SUBSECTOR;	
		case 3:
			return SUBSECTOR1;
		case 4:
			return SUBSECTOR2;
		}
		return SECTOR;
	}
	
}
