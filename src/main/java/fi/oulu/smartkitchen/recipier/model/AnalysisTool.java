package fi.oulu.smartkitchen.recipier.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sam on 12/13/2016.
 */
@Entity
@Table(name = "analysis_tool")
public class AnalysisTool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String version;

    private String url;

    public AnalysisTool() {
    }

    public AnalysisTool(Long id){
        this.id = id;
    }

    public AnalysisTool(String name, String version, String url) {
        this.name = name;
        this.version = version;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
