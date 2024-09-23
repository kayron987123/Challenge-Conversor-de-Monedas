package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionResponse {
    @SerializedName(value = "result")
    private String result;
    @SerializedName(value = "documentation")
    private String documentation;
    @SerializedName(value = "terms_of_use")
    private String terms_of_use;
    @SerializedName(value = "time_last_update_unix")
    private Double time_last_update_unix;
    @SerializedName(value = "time_last_update_utc")
    private String time_last_update_utc;
    @SerializedName(value = "time_next_update_unix")
    private Double time_next_update_unix;
    @SerializedName(value = "time_next_update_utc")
    private String time_next_update_utc;
    @SerializedName(value = "base_code")
    private String base_code;
    @SerializedName(value = "target_code")
    private String target_code;
    @SerializedName(value = "conversion_rate")
    private Double conversion_rate;
    @SerializedName(value = "conversion_result")
    private Double conversion_result;

    public ConversionResponse() {
    }

    public ConversionResponse(String result, String documentation, String terms_of_use, Double time_last_update_unix, String time_last_update_utc, Double time_next_update_unix, String time_next_update_utc, String base_code, String target_code, Double conversion_rate, Double conversion_result) {
        this.result = result;
        this.documentation = documentation;
        this.terms_of_use = terms_of_use;
        this.time_last_update_unix = time_last_update_unix;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_unix = time_next_update_unix;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public Double getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public void setTime_last_update_unix(Double time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public Double getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public void setTime_next_update_unix(Double time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public void setTime_next_update_utc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public Double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(Double conversion_result) {
        this.conversion_result = conversion_result;
    }
}
