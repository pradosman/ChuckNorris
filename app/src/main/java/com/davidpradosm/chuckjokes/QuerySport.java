package com.davidpradosm.chuckjokes;

/**
 * Created by David Prados on 15/11/2017.
 */

        import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuerySport {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("result")
    @Expose
    private Result[] result;

    /**
     * No args constructor for use in serialization
     *
     */
    public QuerySport() {
    }

    /**
     *
     * @param total
     * @param result
     */
    public QuerySport(Integer total, Result[] result) {
        super();
        this.total = total;
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public QuerySport withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    public QuerySport withResult(Result[] result) {
        this.result = result;
        return this;
    }


}



