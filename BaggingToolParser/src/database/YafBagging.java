package database;

import bagging.feature.FeaturesConsts;

public class YafBagging {

	String baggingQuery;

	public YafBagging(){
		
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
				+ "(MAX("+FeaturesConsts.flowEndTime
				+ ")-MIN("+ FeaturesConsts.flowStartTime+ ")) "
				+ "AS totalDuration, "
				+ "SUM("+FeaturesConsts.flowDuration+") AS sumFlowDuration, "
				+ "MAX("+FeaturesConsts.flowDuration+") AS maxFlowDuration, "
				+ "MIN("+FeaturesConsts.flowDuration+") AS minFlowDuration, "
				+ "AVG("+FeaturesConsts.flowDuration+") AS avgFlowDuration, "
				+ "STD("+FeaturesConsts.flowDuration+") AS stdFlowDuration, "
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
				
				+ "SUM("+FeaturesConsts.flowReverseFlowDeltaMiliseconds+") AS sumReverseFlowDMS, "
				+ "MAX("+FeaturesConsts.flowReverseFlowDeltaMiliseconds+") AS maxReverseFlowDMS, "
				+ "MIN("+FeaturesConsts.flowReverseFlowDeltaMiliseconds+") AS minReverseFlowDMS, "
				+ "AVG("+FeaturesConsts.flowReverseFlowDeltaMiliseconds+") AS avgReverseFlowDMS, "
				+ "STD("+FeaturesConsts.flowReverseFlowDeltaMiliseconds+") AS stdReverseFlowDMS "

		
				+ ""
				+ " INTO OUTFILE '/home/eduardo/NIMS/NewBaggingTool/FlowSamples/out/outYaf.txt' FROM flows GROUP BY "
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
