package pl.ttsw.mapstruct.mapstruct.model;

public enum Nation {

    POLISH("POLISH"),
    FRENCH("FRENCH"),
    PORTUGUESE("PORTUGUESE");

    private String nation;

    Nation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return this.nation;
    }

}
