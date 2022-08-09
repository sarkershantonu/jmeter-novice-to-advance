package org.automation.jmeter.cofig.testdata;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpRequestSamplerConf {
private String name;
private String comments;
private HttpHeaderConf headerConfig;
}
