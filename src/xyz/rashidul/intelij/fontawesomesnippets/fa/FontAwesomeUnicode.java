package xyz.rashidul.intelij.fontawesomesnippets.fa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "solid",
    "regular",
    "brands"
})
public class FontAwesomeUnicode {

    @JsonProperty("solid")
    private List<Solid> solid = null;
    @JsonProperty("regular")
    private List<Regular> regular = null;
    @JsonProperty("brands")
    private List<Brand> brands = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("solid")
    public List<Solid> getSolid() {
        return solid;
    }

    @JsonProperty("solid")
    public void setSolid(List<Solid> solid) {
        this.solid = solid;
    }

    @JsonProperty("regular")
    public List<Regular> getRegular() {
        return regular;
    }

    @JsonProperty("regular")
    public void setRegular(List<Regular> regular) {
        this.regular = regular;
    }

    @JsonProperty("brands")
    public List<Brand> getBrands() {
        return brands;
    }

    @JsonProperty("brands")
    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
