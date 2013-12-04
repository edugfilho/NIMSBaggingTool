package format;

import format.FlowOutput.Flow;
import bagging.feature.FeaturesConsts;

public class TranalyzerOutput extends FlowOutput {

	public TranalyzerOutput() {
		super();
		//Duration is calculated via preprocessing
		featuresPresent.put(FeaturesConsts.flowSrcIpAddr, 7);
		featuresPresent.put(FeaturesConsts.flowSrcPort, 8);
		featuresPresent.put(FeaturesConsts.flowDstIpAddr, 9);
		featuresPresent.put(FeaturesConsts.flowDstPort, 10);
		featuresPresent.put(FeaturesConsts.flowDuration, 5);
		featuresPresent.put(FeaturesConsts.flowProtocol, 11);
		//TODO calculate featuresPresent.put(FeaturesConsts.flowNumPkt, 14,15);
		//TODO calculate featuresPresent.put(FeaturesConsts.flowSz, 16,17);
		featuresPresent.put(FeaturesConsts.flowMinPktSz, 18);
		featuresPresent.put(FeaturesConsts.flowMaxPktSz, 19);
		featuresPresent.put(FeaturesConsts.flowAvgPktSz, 20);
		featuresPresent.put(FeaturesConsts.flowIpMinTTl, 27);
		featuresPresent.put(FeaturesConsts.flowIpMaxTTL, 28);
		featuresPresent.put(FeaturesConsts.flowIpTTLChg, 29);
		featuresPresent.put(FeaturesConsts.flowTcpInitWinSz, 40);
		featuresPresent.put(FeaturesConsts.flowTcpAvgWinSz, 41);
		featuresPresent.put(FeaturesConsts.flowTcpMinWinSz, 42);
		featuresPresent.put(FeaturesConsts.flowTcpMaxWinSz, 43);
		featuresPresent.put(FeaturesConsts.flowMinIAT, 78);
		featuresPresent.put(FeaturesConsts.flowMaxIAT, 79);
		featuresPresent.put(FeaturesConsts.flowMeanIAT, 80);
		featuresPresent.put(FeaturesConsts.flowMedianIAT, 82);
		featuresPresent.put(FeaturesConsts.flowRangeIAT, 86);
		featuresPresent.put(FeaturesConsts.flowStdIAT, 87);
		setUsedFeaturesWithCurrentPresentFeatures();
		
		featuresPresent.put(FeaturesConsts.FlowDir, 0); 	
		featuresPresent.put(FeaturesConsts.FlowInd, 1);
		featuresPresent.put(FeaturesConsts.FlowStat, 2);
		featuresPresent.put(FeaturesConsts.FlowUnixTimeFirst, 3);
		featuresPresent.put(FeaturesConsts.FlowUnixTimeLast, 4);			
		featuresPresent.put(FeaturesConsts.FlowETHVlanID, 6);
		//TODO featuresPresent.put(FeaturesConsts.FlowSrcMac_DstMac_NumP = "SrcMac_DstMac_NumP, 12);				
		featuresPresent.put(FeaturesConsts.FlowDstPortClass, 13);						
		featuresPresent.put(FeaturesConsts.FlowPktps, 21);
		featuresPresent.put(FeaturesConsts.FlowBytps, 22);
		featuresPresent.put(FeaturesConsts.FlowPktAsm, 23);
		featuresPresent.put(FeaturesConsts.FlowBytAsm, 24);
		featuresPresent.put(FeaturesConsts.FlowIpMindIPID, 25);
		featuresPresent.put(FeaturesConsts.FlowIpMaxdIPID, 26);
		featuresPresent.put(FeaturesConsts.FlowIpTOS, 30); 	
		featuresPresent.put(FeaturesConsts.FlowIpFlags, 31);
		featuresPresent.put(FeaturesConsts.FlowIpOptCnt, 32); 
		featuresPresent.put(FeaturesConsts.FlowIpOptCpCl_Num, 33);	
		featuresPresent.put(FeaturesConsts.FlowTcpPSeqCnt, 34);
		featuresPresent.put(FeaturesConsts.FlowTcpSeqSntBytes, 35);
		featuresPresent.put(FeaturesConsts.FlowTcpSeqFaultCnt, 36);
		featuresPresent.put(FeaturesConsts.FlowTcpPAckCnt, 37);
		featuresPresent.put(FeaturesConsts.FlowTcpFlwLssAckRcvdBytes, 38);
		featuresPresent.put(FeaturesConsts.FlowTcpAckFaultCnt, 39);
		featuresPresent.put(FeaturesConsts.FlowTcpWinSzDwnCnt, 44);
		featuresPresent.put(FeaturesConsts.FlowTcpWinSzUpCnt, 45);
		featuresPresent.put(FeaturesConsts.FlowTcpWinSzChgDirCnt, 46);
		featuresPresent.put(FeaturesConsts.FlowTcpAggrFlags, 47);
		featuresPresent.put(FeaturesConsts.FlowTcpAggrAnomaly, 48);
		featuresPresent.put(FeaturesConsts.FlowTcpOptPktCnt, 49);
		featuresPresent.put(FeaturesConsts.FlowTcpOptCnt, 50);
		featuresPresent.put(FeaturesConsts.FlowTcpAggrOptions, 51);
		featuresPresent.put(FeaturesConsts.FlowTcpMSS, 52);
		featuresPresent.put(FeaturesConsts.FlowTcpWS, 53);
		featuresPresent.put(FeaturesConsts.FlowTcpSSA_SAATrip, 54);
		featuresPresent.put(FeaturesConsts.FlowTcpRTTSseqAA, 55);
		featuresPresent.put(FeaturesConsts.FlowTcpRTTAckTripMin, 56);
		featuresPresent.put(FeaturesConsts.FlowTcpRTTAckTripMax, 57);
		featuresPresent.put(FeaturesConsts.FlowTcpRTTAckTripAve, 58);
		featuresPresent.put(FeaturesConsts.FlowTcpStates, 59);
		featuresPresent.put(FeaturesConsts.FlowIcmpType_Code, 60);
		featuresPresent.put(FeaturesConsts.FlowIcmpEchoSuccRatio, 61);
		featuresPresent.put(FeaturesConsts.FlowConnSrc, 62);
		featuresPresent.put(FeaturesConsts.FlowConnDst, 63);
		featuresPresent.put(FeaturesConsts.FlowConnSrcDst, 64);
		featuresPresent.put(FeaturesConsts.FlowMinPl, 65);
		featuresPresent.put(FeaturesConsts.FlowMaxPl, 66);
		featuresPresent.put(FeaturesConsts.FlowMeanPl, 67);
		featuresPresent.put(FeaturesConsts.FlowLowQuartilePl, 68);
		featuresPresent.put(FeaturesConsts.FlowMedianPl, 69);
		featuresPresent.put(FeaturesConsts.FlowUppQuartilePl, 70);
		featuresPresent.put(FeaturesConsts.FlowIqdPl, 71);
		featuresPresent.put(FeaturesConsts.FlowModePl, 72);
		featuresPresent.put(FeaturesConsts.FlowRangePl, 73);
		featuresPresent.put(FeaturesConsts.FlowStdPl, 74);
		featuresPresent.put(FeaturesConsts.FlowStdrobPl, 75);
		featuresPresent.put(FeaturesConsts.FlowSkewPl, 76);
		featuresPresent.put(FeaturesConsts.FlowExcPl, 77);
		featuresPresent.put(FeaturesConsts.FlowLowQuartileIat, 81);
		featuresPresent.put(FeaturesConsts.FlowUppQuartileIat, 83);
		featuresPresent.put(FeaturesConsts.FlowIqdIat, 84);
		featuresPresent.put(FeaturesConsts.FlowModeIat, 85);
		featuresPresent.put(FeaturesConsts.FlowRobStdIat, 88);
		featuresPresent.put(FeaturesConsts.FlowSkewIat, 89);
		featuresPresent.put(FeaturesConsts.FlowExcIat, 90);
		featuresPresent.put(FeaturesConsts.FlowL2L3L4Pl_Iat, 91);
		featuresPresent.put(FeaturesConsts.FlowPs_Iat_Cnt_PsCnt_IatCnt,92 );
		
		
	}

	@Override
	public String preProcessField(String fieldName, Flow f) {
		Integer flowIndex = featuresPresent.get(fieldName);
		String featureContent = f.get(flowIndex).replaceAll("\\s+", "");
		return featureContent;
	}

	@Override
	public String getSeparator() {
		return "\t";
	}
	@Override
	public Integer ignoreLines() {
		return 1;
	}


}
