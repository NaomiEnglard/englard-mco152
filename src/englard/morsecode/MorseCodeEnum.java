package englard.morsecode;

public enum MorseCodeEnum {

	A(".-"), B("-..."), C("-.-."), D("-.."), E("."), F("..-."), G("--."), H(
			"...."), I(".."), J(".---"), K("-.-"), L(".-.."), M("--"), N("-."), O(
			"---"), P(".--."), Q("--.-"), R(".-."), S("..."), T("-"), U("..-"), V(
			"...-"), W(".--"), X("-..-"), Y("-.--"), Z("--..");
	private String code;

	MorseCodeEnum(String dotDash) {
		this.code = dotDash;
	}


	public String getCode() {
		return code;
	}

}
