package database;

import util.BaggingToolUtil;
import bagging.feature.FeaturesConsts;

public class NetmateBagging extends OutputBagging{

	/**
	 * 
	 * @param outputName The name of the parsed flow output, as it was stored in the database
	 */
	public NetmateBagging(String outputName) {

		baggingQuery = "SELECT "
				+ FeaturesConsts.flowSrcIpAddr
				+ ", "
				+ FeaturesConsts.flowDstIpAddr
				+ ", "
				+ FeaturesConsts.flowSrcPort
				+ ", "
				+ FeaturesConsts.flowDstPort
				+ ", "
				+ FeaturesConsts.flowProtocol+" AS protocol, "
				+ "SUM("+FeaturesConsts.flowTotalFwdPkt+") AS sumFwdPkt, "
				+ "MAX("+FeaturesConsts.flowTotalFwdPkt+") AS maxFwdPkt, "
				+ "MIN("+FeaturesConsts.flowTotalFwdPkt+") AS minFwdPkt, "
				+ "AVG("+FeaturesConsts.flowTotalFwdPkt+") AS avgFwdPkt, "
				+ "STD("+FeaturesConsts.flowTotalFwdPkt+") AS stdFwdPkt, "
				+ "SUM("+FeaturesConsts.flowTotalFwdSz+") AS sumFwdSz, "
				+ "MAX("+FeaturesConsts.flowTotalFwdSz+") AS maxFwdSz, "
				+ "MIN("+FeaturesConsts.flowTotalFwdSz+") AS minFwdSz, "
				+ "AVG("+FeaturesConsts.flowTotalFwdSz+") AS avgFwdSz, "
				+ "STD("+FeaturesConsts.flowTotalFwdSz+") AS stdFwdSz, "
				+ "SUM("+FeaturesConsts.flowTotalBwdPkt+") AS sumBwdPkt, "
				+ "MAX("+FeaturesConsts.flowTotalBwdPkt+") AS maxBwdPkt, "
				+ "MIN("+FeaturesConsts.flowTotalBwdPkt+") AS minBwdPkt, "
				+ "AVG("+FeaturesConsts.flowTotalBwdPkt+") AS avgBwdPkt, "
				+ "STD("+FeaturesConsts.flowTotalBwdPkt+") AS stdBwdPkt, "
				+ "SUM("+FeaturesConsts.flowTotalBwdSz+") AS sumBwdSz, "
				+ "MAX("+FeaturesConsts.flowTotalBwdSz+") AS maxBwdSz, "
				+ "MIN("+FeaturesConsts.flowTotalBwdSz+") AS minBwdSz, "
				+ "AVG("+FeaturesConsts.flowTotalBwdSz+") AS avgBwdSz, "
				+ "STD("+FeaturesConsts.flowTotalBwdSz+") AS stdBwdSz, "
				+ "MAX("+FeaturesConsts.flowTotalFwdPkt+"+"+FeaturesConsts.flowTotalBwdPkt+") AS maxTotalPkt, "
				+ "MIN("+FeaturesConsts.flowTotalFwdPkt+"+"+FeaturesConsts.flowTotalBwdPkt+") AS minTotalPkt, "
				+ "AVG("+FeaturesConsts.flowTotalFwdPkt+"+"+FeaturesConsts.flowTotalBwdPkt+") AS avgTotalPkt, "
				+ "STD("+FeaturesConsts.flowTotalFwdPkt+"+"+FeaturesConsts.flowTotalBwdPkt+") AS stdTotalPkt, "
				+ "MAX("+FeaturesConsts.flowTotalFwdSz+"+"+FeaturesConsts.flowTotalBwdSz+") AS maxTotalSz, "
				+ "MIN("+FeaturesConsts.flowTotalFwdSz+"+"+FeaturesConsts.flowTotalBwdSz+") AS minTotalSz, "
				+ "AVG("+FeaturesConsts.flowTotalFwdSz+"+"+FeaturesConsts.flowTotalBwdSz+") AS avgTotalSz, "
				+ "STD("+FeaturesConsts.flowTotalFwdSz+"+"+FeaturesConsts.flowTotalBwdSz+") AS stdTotalSz, "
				+ "MIN("+FeaturesConsts.flowMinFwdPktSz+") AS minMinFwdPktSz, "
				+ "MAX("+FeaturesConsts.flowMaxFwdPktSz+") AS maxMaxFwdPktSz, "
				+ "AVG("+FeaturesConsts.flowMeanFwdPktSz+") AS avgMeanFwdPktSz, "
				+ "STD("+FeaturesConsts.flowStdFwdPktSz+") AS stdStdFwdPktSz, "
				+ "MIN("+FeaturesConsts.flowMinBwdPktSz+") AS minMinBwdPktSz, "
				+ "AVG("+FeaturesConsts.flowMeanBwdPktSz+") AS avgMeanBwdPktSz, "
				+ "MAX("+FeaturesConsts.flowMaxBwdPktSz+") AS maxMaxBwdPktSz, "
				+ "STD("+FeaturesConsts.flowStdBwdPktSz+") AS stdStdBwdPktSz, "			
				+ "MIN("+FeaturesConsts.flowMinFIAT+") AS minMinFIAT, "
				+ "MAX("+FeaturesConsts.flowMaxFIAT+") AS maxMaxFIAT, "
				+ "AVG("+FeaturesConsts.flowMeanFIAT+") AS avgMeanFIAT, "
				+ "STD("+FeaturesConsts.flowStdFIAT+") AS stdStdFIAT, "
				+ "MIN("+FeaturesConsts.flowMinBIAT+") AS minMinBIAT, "
				+ "MAX("+FeaturesConsts.flowMaxBIAT+") AS maxMaxBIAT, "
				+ "AVG("+FeaturesConsts.flowMeanBIAT+") AS avgMeanBIAT, "
				+ "STD("+FeaturesConsts.flowStdBIAT+") AS stdStdBIAT, "
				+ "MIN("+FeaturesConsts.flowDuration+") AS minDuration, "
				+ "MAX("+FeaturesConsts.flowDuration+") AS maxDuration, "
				+ "AVG("+FeaturesConsts.flowDuration+") AS avgDuration, "
				+ "STD("+FeaturesConsts.flowDuration+") AS stdDuration, "
				
				+ "MIN("+FeaturesConsts.flowMinActive+") AS minMinActive, "
				+ "MAX("+FeaturesConsts.flowMaxActive+") AS maxMaxActive, "
				+ "AVG("+FeaturesConsts.flowMeanActive+") AS avgMeanActive, "
				+ "STD("+FeaturesConsts.flowStdActive+") AS stdStdActive, "
				
				+ "MIN("+FeaturesConsts.flowMinIdle+") AS minMinIdle, "
				+ "MAX("+FeaturesConsts.flowMinIdle+") AS maxMaxIdle, "
				+ "AVG("+FeaturesConsts.flowMinIdle+") AS avgMeanIdle, "
				+ "STD("+FeaturesConsts.flowMinIdle+") AS stdStdIdle, "

				+ "MIN("+FeaturesConsts.flowSubflowNumFwdPkt+") AS minSflowFwdPkt, "
				+ "MAX("+FeaturesConsts.flowSubflowNumFwdPkt+") AS maxSflowFwdPkt, "
				+ "AVG("+FeaturesConsts.flowSubflowNumFwdPkt+") AS avgSflowFwdPkt, "
				+ "STD("+FeaturesConsts.flowSubflowNumFwdPkt+") AS stdSflowFwdPkt, "
				
				+ "MIN("+FeaturesConsts.flowSubFlowFwdSz+") AS minSflowFwdSz, "
				+ "MAX("+FeaturesConsts.flowSubFlowFwdSz+") AS maxSflowFwdSz, "
				+ "AVG("+FeaturesConsts.flowSubFlowFwdSz+") AS avgSflowFwdSz, "
				+ "STD("+FeaturesConsts.flowSubFlowFwdSz+") AS stdSflowFwdSz, "
				
				+ "MIN("+FeaturesConsts.flowSubflowNumBwdPkt+") AS minSflowBwdPkt, "
				+ "MAX("+FeaturesConsts.flowSubflowNumBwdPkt+") AS maxSflowBwdPkt, "
				+ "AVG("+FeaturesConsts.flowSubflowNumBwdPkt+") AS avgSflowBwdPkt, "
				+ "STD("+FeaturesConsts.flowSubflowNumBwdPkt+") AS stdSflowBwdPkt, "
								
				+ "MIN("+FeaturesConsts.flowSubFlowBwdSz+")	AS minSflowBwdSz, "
				+ "MAX("+FeaturesConsts.flowSubFlowBwdSz+") AS maxSflowBwdSz, "
				+ "AVG("+FeaturesConsts.flowSubFlowBwdSz+") AS avgSflowBwdSz, "
				+ "STD("+FeaturesConsts.flowSubFlowBwdSz+") AS stdSflowBwdSz, "
				
				+ "MIN("+FeaturesConsts.flowSubflowNumFwdPkt+"+"+FeaturesConsts.flowSubflowNumBwdPkt+") AS minTotalSflowPkt, "
				+ "MAX("+FeaturesConsts.flowSubflowNumFwdPkt+"+"+FeaturesConsts.flowSubflowNumBwdPkt+") AS maxTotalSflowPkt, "
				+ "AVG("+FeaturesConsts.flowSubflowNumFwdPkt+"+"+FeaturesConsts.flowSubflowNumBwdPkt+") AS avgTotalSflowPkt, "
				+ "STD("+FeaturesConsts.flowSubflowNumFwdPkt+"+"+FeaturesConsts.flowSubflowNumBwdPkt+") AS stdTotalSflowPkt, "
				
				+ "MIN("+FeaturesConsts.flowSubFlowFwdSz+"+"+FeaturesConsts.flowSubFlowBwdSz+") AS minTotalSflowSz, "
				+ "MAX("+FeaturesConsts.flowSubFlowFwdSz+"+"+FeaturesConsts.flowSubFlowBwdSz+") AS maxTotalSflowSz, "
				+ "AVG("+FeaturesConsts.flowSubFlowFwdSz+"+"+FeaturesConsts.flowSubFlowBwdSz+") AS avgTotalSflowSz, "
				+ "STD("+FeaturesConsts.flowSubFlowFwdSz+"+"+FeaturesConsts.flowSubFlowBwdSz+") AS stdTotalSflowSz, "
				
				+ "MIN("+FeaturesConsts.flowHeaderFwdTotalSz+") AS minHeaderFwdSz, "
				+ "MAX("+FeaturesConsts.flowHeaderFwdTotalSz+") AS maxHeaderFwdSz, "
				+ "AVG("+FeaturesConsts.flowHeaderFwdTotalSz+") AS avgHeaderFwdSz, "
				+ "STD("+FeaturesConsts.flowHeaderFwdTotalSz+") AS stdHeaderFwdSz, "
				
				+ "MIN("+FeaturesConsts.flowHeaderBwdTotalSz+") AS minHeaderBwdSz, "
				+ "MAX("+FeaturesConsts.flowHeaderBwdTotalSz+") AS maxHeaderBwdSz, "
				+ "AVG("+FeaturesConsts.flowHeaderBwdTotalSz+") AS avgHeaderBwdSz, "
				+ "STD("+FeaturesConsts.flowHeaderBwdTotalSz+") AS stdHeaderBwdSz "

				+ ""
				+ "INTO OUTFILE '"+BaggingToolUtil.getPath("OUTPUT_FOLDER")+"grouped_Netmate_Output"+BaggingToolUtil.getTimeStamp()+".txt'" +
						" FROM flows JOIN output ON flows.Output_Id=output.output_id AND" +
						" output.OutputName LIKE '"+outputName+"' GROUP BY "
				+ FeaturesConsts.flowSrcIpAddr + ", "
				+ FeaturesConsts.flowDstIpAddr + ", "
				+ FeaturesConsts.flowSrcPort + ", "
				+ FeaturesConsts.flowDstPort;
	}

	public String getBaggingQuery() {
		return baggingQuery;
	}

	public void setBaggingQuery(String baggingQuery) {
		this.baggingQuery = baggingQuery;
	}
}
