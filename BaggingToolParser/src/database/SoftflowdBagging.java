package database;

import util.BaggingToolUtil;
import bagging.feature.FeaturesConsts;

public class SoftflowdBagging {

	String baggingQuery;

	/**
	 * 
	 * @param outputName The name of the parsed flow output, as it was stored in the database
	 */
	public SoftflowdBagging(String outputName) {

		baggingQuery = "SELECT "
				+ FeaturesConsts.flowSrcIpAddr
				+ ", "
				+ FeaturesConsts.flowDstIpAddr
				+ ", "
				+ FeaturesConsts.flowSrcPort
				+ ", "
				+ FeaturesConsts.flowDstPort
				+ ", "
				+ FeaturesConsts.flowProtocol
				+ " AS protocol, "
				+ "(MAX("+FeaturesConsts.flowEndTime
				+ ")-MIN("+ FeaturesConsts.flowStartTime+ ")) "
				+ "AS totalDurationMillisec, "
				+ "MAX("+FeaturesConsts.flowDuration+") AS maxFlowDuration, "
				+ "MIN("+FeaturesConsts.flowDuration+") AS minFlowDuration, "
				+ "AVG("+FeaturesConsts.flowDuration+") AS avgFlowDuration, "
				+ "STD("+FeaturesConsts.flowDuration+") AS stdFlowDuration, "
				+ FeaturesConsts.flowProtocol+" AS protocol, "
				+ "MIN("+FeaturesConsts.flowNumPkt+") AS minNumPkt, "
				+ "MAX("+FeaturesConsts.flowNumPkt+") AS maxNumPkt, "
				+ "AVG("+FeaturesConsts.flowNumPkt+") AS avgNumPkt, "
				+ "STD("+FeaturesConsts.flowNumPkt+") AS stdNumPkt, "
				
				+ "MIN("+FeaturesConsts.flowTotalBwdPkt+") AS minNumBwdPkt, "
				+ "MAX("+FeaturesConsts.flowTotalBwdPkt+") AS maxNumBwdPkt, "
				+ "AVG("+FeaturesConsts.flowTotalBwdPkt+") AS avgNumBwdPkt, "
				+ "STD("+FeaturesConsts.flowTotalBwdPkt+") AS stdNumBwdPkt, "
				
				+ "MIN("+FeaturesConsts.flowTotalFwdPkt+") AS minNumFwdPkt, "
				+ "MAX("+FeaturesConsts.flowTotalFwdPkt+") AS maxNumFwdPkt, "
				+ "AVG("+FeaturesConsts.flowTotalFwdPkt+") AS avgNumFwdPkt, "
				+ "STD("+FeaturesConsts.flowTotalFwdPkt+") AS stdNumFwdPkt, "

				+ "MIN("+FeaturesConsts.flowSz+") AS minSz, "
				+ "MAX("+FeaturesConsts.flowSz+") AS maxSz, "
				+ "AVG("+FeaturesConsts.flowSz+") AS avgSz, "
				+ "STD("+FeaturesConsts.flowSz+") AS stdSz, "
				
				+ "MIN("+FeaturesConsts.flowTotalBwdSz+") AS minBwdSz, "
				+ "MAX("+FeaturesConsts.flowTotalBwdSz+") AS maxBwdSz, "
				+ "AVG("+FeaturesConsts.flowTotalBwdSz+") AS avgBwdSz, "
				+ "STD("+FeaturesConsts.flowTotalBwdSz+") AS stdBwdSz, "
				
				+ "MIN("+FeaturesConsts.flowTotalFwdSz+") AS minBwdSz, "
				+ "MAX("+FeaturesConsts.flowTotalFwdSz+") AS maxFwdSz, "
				+ "AVG("+FeaturesConsts.flowTotalFwdSz+") AS avgFwdSz, "
				+ "STD("+FeaturesConsts.flowTotalFwdSz+") AS stdFwdSz, "
				
				+ "MIN("+FeaturesConsts.flowBytesPerSec+") AS minBps, "
				+ "MAX("+FeaturesConsts.flowBytesPerSec+") AS maxBps, "
				+ "AVG("+FeaturesConsts.flowBytesPerSec+") AS avgBps, "
				+ "STD("+FeaturesConsts.flowBytesPerSec+") AS stdBps, "
				
				+ "MIN("+FeaturesConsts.flowPktPerSec+") AS minPps, "
				+ "MAX("+FeaturesConsts.flowPktPerSec+") AS maxPps, "
				+ "AVG("+FeaturesConsts.flowPktPerSec+") AS avgPps, "
				+ "STD("+FeaturesConsts.flowPktPerSec+") AS stdPps, "
				
				+ "MIN("+FeaturesConsts.flowBytesPerPkt+") AS minBpp, "
				+ "MAX("+FeaturesConsts.flowBytesPerPkt+") AS maxBpp, "
				+ "AVG("+FeaturesConsts.flowBytesPerPkt+") AS avgBpp, "
				+ "STD("+FeaturesConsts.flowBytesPerPkt+") AS stdBpp "
				
				
				+ ""
				+ "INTO OUTFILE '"+BaggingToolUtil.getPath("OUTPUT_FOLDER")+"outSoftflowd.txt' FROM flows JOIN output ON flows.Output_Id=output.output_id AND" +
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
