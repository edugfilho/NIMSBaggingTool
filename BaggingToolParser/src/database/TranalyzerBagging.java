package database;

import util.BaggingToolUtil;
import bagging.feature.FeaturesConsts;

public class TranalyzerBagging extends OutputBagging{


	/**
	 * 
	 * @param outputName The name of the parsed flow output, as it was stored in the database
	 */
	public TranalyzerBagging(String outputName) {
		baggingQuery = "SELECT "
				+ FeaturesConsts.flowSrcIpAddr
				+ ", "
				+ FeaturesConsts.flowDstIpAddr
				+ ", "
				+ FeaturesConsts.flowSrcPort
				+ ", "
				+ FeaturesConsts.flowDstPort
				+ ", "
				+ "(MAX("+FeaturesConsts.flowUnixTimeLast
				+ ")-MIN("+ FeaturesConsts.flowUnixTimeFirst+ ")) "
				+ "AS totalDurationMillisec, "
				+ "MAX("+FeaturesConsts.flowDuration+") AS maxFlowDuration, "
				+ "MIN("+FeaturesConsts.flowDuration+") AS minFlowDuration, "
				+ "AVG("+FeaturesConsts.flowDuration+") AS avgFlowDuration, "
				+ "STD("+FeaturesConsts.flowDuration+") AS stdFlowDuration, "
				+ FeaturesConsts.flowProtocol+" AS protocol, "
				+ "SUM("+FeaturesConsts.flowNumPkt+") AS totalNumPkt, "
				+ "MIN("+FeaturesConsts.flowNumPkt+") AS minNumPkt, "
				+ "MAX("+FeaturesConsts.flowNumPkt+") AS maxNumPkt, "
				+ "AVG("+FeaturesConsts.flowNumPkt+") AS avgNumPkt, "
				+ "STD("+FeaturesConsts.flowNumPkt+") AS stdNumPkt, "
				+ "SUM("+FeaturesConsts.flowSz+") AS totalSz, "
				+ "MIN("+FeaturesConsts.flowSz+") AS minSz, "
				+ "MAX("+FeaturesConsts.flowSz+") AS maxSz, "
				+ "AVG("+FeaturesConsts.flowSz+") AS avgSz, "
				+ "STD("+FeaturesConsts.flowSz+") AS stdSz, "
				+ "MIN("+FeaturesConsts.flowMinPktSz+") AS minPktSz, "
				+ "MAX("+FeaturesConsts.flowMaxPktSz+") AS maxPktSz, "
				+ "AVG("+FeaturesConsts.flowAvgPktSz+") AS avgAvgPktSz, "
				+ "MIN("+FeaturesConsts.flowIpMinTTL+") AS minIpMinTTL, "
				+ "MAX("+FeaturesConsts.flowIpMaxTTL+") AS maxIpMaxTTL, "
				+ "SUM("+FeaturesConsts.flowIpTTLChg+") AS totalIpTTLChg, "
				+ "MIN("+FeaturesConsts.flowTcpInitWinSz+") AS minTcpInitWinSz, "
				+ "MAX("+FeaturesConsts.flowTcpInitWinSz+") AS maxTcpInitWinSz, "
				+ "AVG("+FeaturesConsts.flowTcpAvgWinSz+") AS avgTcpAvgWinSz, "
				+ "MIN("+FeaturesConsts.flowTcpMinWinSz+") AS minTcpMinWinSz, "
				+ "MAX("+FeaturesConsts.flowTcpMaxWinSz+") AS maxTcpMaxWinSz, "
				+ "MIN("+FeaturesConsts.flowMinIAT+") AS minMinIat, "
				+ "MAX("+FeaturesConsts.flowMaxIAT+") AS maxMaxIat, "
				+ "AVG("+FeaturesConsts.flowMeanIAT+") AS avgMeanIat, "
				+ "MIN("+FeaturesConsts.flowRangeIAT+") AS minRangeIat, "
				+ "MAX("+FeaturesConsts.flowRangeIAT+") AS maxRangeIat, "
				+ "AVG("+FeaturesConsts.flowRangeIAT+") AS avgRangeIat, "
				+ "STD("+FeaturesConsts.flowRangeIAT+") AS stdRangeIat, "
				+ "STD("+FeaturesConsts.flowStdIAT+") AS stdRangeIat, "
				+ "AVG("+FeaturesConsts.flowMedianIAT+") AS avgMedianIat "
				+ ""
				+ "INTO OUTFILE '"+BaggingToolUtil.getPath("OUTPUT_FOLDER")+"grouped_Tranalyzer_Output"+BaggingToolUtil.getTimeStamp()+".txt' FROM flows JOIN output ON flows.Output_Id=output.output_id AND" +
						" output.OutputName LIKE '"+outputName+"' GROUP BY "
				+ FeaturesConsts.flowSrcIpAddr + ", "
				+ FeaturesConsts.flowDstIpAddr + ", "
				+ FeaturesConsts.flowSrcPort + ", "
				+ FeaturesConsts.flowDstPort;

		// TODO SUBTRACT first packet start time from last packet end time in
		// SELECT

	}

	/*
	 * Tranalyzer bagging features:
	 * median of MedianIat
	 */

	public String getBaggingQuery() {
		return baggingQuery;
	}

	public void setBaggingQuery(String baggingQuery) {
		this.baggingQuery = baggingQuery;
	}

}
