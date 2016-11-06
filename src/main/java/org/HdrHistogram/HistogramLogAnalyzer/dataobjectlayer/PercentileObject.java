/**
 * Written by Azul Systems, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */

package org.HdrHistogram.HistogramLogAnalyzer.dataobjectlayer;

public class PercentileObject {

    private double latencyAxisValue;
    // 1/(1-percentile)
    private double percentileAxisValue;

    private String tag;

    // "insert" object
	public PercentileObject(double latencyAxisValue, double percentileValue, String tag) {
		this.latencyAxisValue = latencyAxisValue;

        Double cvalue = 1.0d/ (1.0-percentileValue);
        if(cvalue.isInfinite()) {
            cvalue = (double) 0;
        }
        this.percentileAxisValue = cvalue;

        this.tag = tag;
	}

	// "query" object
	public PercentileObject(double latencyAxisValue, double percentileAxisValue) {
		this.latencyAxisValue = latencyAxisValue;
		this.percentileAxisValue = percentileAxisValue;
	}

	public double getLatencyAxisValue() {
		return latencyAxisValue;
	}

	public double getPercentileAxisValue() {
		return percentileAxisValue;
	}

	public String getTag() {
		return tag;
	}

}