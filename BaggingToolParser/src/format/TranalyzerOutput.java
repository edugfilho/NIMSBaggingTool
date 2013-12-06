package format;

import java.util.StringTokenizer;

import format.FlowOutput.Flow;
import bagging.feature.FeaturesConsts;

public class TranalyzerOutput extends FlowOutput {

	final int flowNumPktIndex = 93;
	final int flowSzIndex = 94;
	final int flowSrcMacIndex = 95;
	final int flowDstMacIndex = 96;

	public TranalyzerOutput() {
		super();
		// Duration is calculated via preprocessing
		featuresPresent.put(FeaturesConsts.flowUnixTimeFirst, 3);
		featuresPresent.put(FeaturesConsts.flowUnixTimeLast, 4);
		featuresPresent.put(FeaturesConsts.flowSrcIpAddr, 7);
		featuresPresent.put(FeaturesConsts.flowSrcPort, 8);
		featuresPresent.put(FeaturesConsts.flowDstIpAddr, 9);
		featuresPresent.put(FeaturesConsts.flowDstPort, 10);
		featuresPresent.put(FeaturesConsts.flowDuration, 5);
		featuresPresent.put(FeaturesConsts.flowSz, flowSzIndex);
		featuresPresent.put(FeaturesConsts.flowNumPkt, flowNumPktIndex);
		featuresPresent.put(FeaturesConsts.flowProtocol, 11);
		featuresPresent.put(FeaturesConsts.flowMinPktSz, 18);
		featuresPresent.put(FeaturesConsts.flowMaxPktSz, 19);
		featuresPresent.put(FeaturesConsts.flowAvgPktSz, 20);
		featuresPresent.put(FeaturesConsts.flowIpMinTTL, 27);
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

		featuresPresent.put(FeaturesConsts.flowDir, 0);
		featuresPresent.put(FeaturesConsts.flowInd, 1);
		featuresPresent.put(FeaturesConsts.flowStat, 2);
		featuresPresent.put(FeaturesConsts.flowETHVlanID, 6);
		featuresPresent.put(FeaturesConsts.flowNumP, 12);
		featuresPresent.put(FeaturesConsts.flowDstPortClass, 13);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 14);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 15);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 16);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 17);
		featuresPresent.put(FeaturesConsts.flowPktps, 21);
		featuresPresent.put(FeaturesConsts.flowBytps, 22);
		featuresPresent.put(FeaturesConsts.flowPktAsm, 23);
		featuresPresent.put(FeaturesConsts.flowBytAsm, 24);
		featuresPresent.put(FeaturesConsts.flowIpMindIPID, 25);
		featuresPresent.put(FeaturesConsts.flowIpMaxdIPID, 26);
		featuresPresent.put(FeaturesConsts.flowIpTOS, 30);
		featuresPresent.put(FeaturesConsts.flowIpFlags, 31);
		featuresPresent.put(FeaturesConsts.flowIpOptCnt, 32);
		featuresPresent.put(FeaturesConsts.flowIpOptCpCl_Num, 33);
		featuresPresent.put(FeaturesConsts.flowTcpPSeqCnt, 34);
		featuresPresent.put(FeaturesConsts.flowTcpSeqSntBytes, 35);
		featuresPresent.put(FeaturesConsts.flowTcpSeqFaultCnt, 36);
		featuresPresent.put(FeaturesConsts.flowTcpPAckCnt, 37);
		featuresPresent.put(FeaturesConsts.flowTcpFlwLssAckRcvdBytes, 38);
		featuresPresent.put(FeaturesConsts.flowTcpAckFaultCnt, 39);
		featuresPresent.put(FeaturesConsts.flowTcpWinSzDwnCnt, 44);
		featuresPresent.put(FeaturesConsts.flowTcpWinSzUpCnt, 45);
		featuresPresent.put(FeaturesConsts.flowTcpWinSzChgDirCnt, 46);
		featuresPresent.put(FeaturesConsts.flowTcpAggrFlags, 47);
		featuresPresent.put(FeaturesConsts.flowTcpAggrAnomaly, 48);
		featuresPresent.put(FeaturesConsts.flowTcpOptPktCnt, 49);
		featuresPresent.put(FeaturesConsts.flowTcpOptCnt, 50);
		featuresPresent.put(FeaturesConsts.flowTcpAggrOptions, 51);
		featuresPresent.put(FeaturesConsts.flowTcpMSS, 52);
		featuresPresent.put(FeaturesConsts.flowTcpWS, 53);
		featuresPresent.put(FeaturesConsts.flowTcpSSA_SAATrip, 54);
		featuresPresent.put(FeaturesConsts.flowTcpRTTSseqAA, 55);
		featuresPresent.put(FeaturesConsts.flowTcpRTTAckTripMin, 56);
		featuresPresent.put(FeaturesConsts.flowTcpRTTAckTripMax, 57);
		featuresPresent.put(FeaturesConsts.flowTcpRTTAckTripAve, 58);
		featuresPresent.put(FeaturesConsts.flowTcpStates, 59);
		featuresPresent.put(FeaturesConsts.flowIcmpType_Code, 60);
		featuresPresent.put(FeaturesConsts.flowIcmpEchoSuccRatio, 61);
		featuresPresent.put(FeaturesConsts.flowConnSrc, 62);
		featuresPresent.put(FeaturesConsts.flowConnDst, 63);
		featuresPresent.put(FeaturesConsts.flowConnSrcDst, 64);
		featuresPresent.put(FeaturesConsts.flowMinPl, 65);
		featuresPresent.put(FeaturesConsts.flowMaxPl, 66);
		featuresPresent.put(FeaturesConsts.flowMeanPl, 67);
		featuresPresent.put(FeaturesConsts.flowLowQuartilePl, 68);
		featuresPresent.put(FeaturesConsts.flowMedianPl, 69);
		featuresPresent.put(FeaturesConsts.flowUppQuartilePl, 70);
		featuresPresent.put(FeaturesConsts.flowIqdPl, 71);
		featuresPresent.put(FeaturesConsts.flowModePl, 72);
		featuresPresent.put(FeaturesConsts.flowRangePl, 73);
		featuresPresent.put(FeaturesConsts.flowStdPl, 74);
		featuresPresent.put(FeaturesConsts.flowStdrobPl, 75);
		featuresPresent.put(FeaturesConsts.flowSkewPl, 76);
		featuresPresent.put(FeaturesConsts.flowExcPl, 77);
		featuresPresent.put(FeaturesConsts.flowLowQuartileIat, 81);
		featuresPresent.put(FeaturesConsts.flowUppQuartileIat, 83);
		featuresPresent.put(FeaturesConsts.flowIqdIat, 84);
		featuresPresent.put(FeaturesConsts.flowModeIat, 85);
		featuresPresent.put(FeaturesConsts.flowRobStdIat, 88);
		featuresPresent.put(FeaturesConsts.flowSkewIat, 89);
		featuresPresent.put(FeaturesConsts.flowExcIat, 90);
		featuresPresent.put(FeaturesConsts.flowL2L3L4Pl_Iat, 91);
		featuresPresent.put(FeaturesConsts.flowPs_Iat_Cnt_PsCnt_IatCnt, 92);
		featuresPresent.put(FeaturesConsts.flowSrcMacAddr, flowSrcMacIndex);
		featuresPresent.put(FeaturesConsts.flowDstMacAddr, flowDstMacIndex);

	}

	@Override
	public String preProcessField(String fieldName, Flow f) {
		Integer flowIndex = featuresPresent.get(fieldName);
		String featureContent = f.get(flowIndex).replaceAll("\\s+", "");
		if (fieldName.equals(FeaturesConsts.flowSrcIpAddr)
				|| fieldName.equals(FeaturesConsts.flowDstIpAddr)) {
			// Remove IPV6 and invalid ip address flows
			if (featureContent.contains(":")
					|| featureContent.contains("0.0.0.0")) {
				return null;
			}

		}
		return featureContent;
	}

	/**
	 * Calculates total size and number of packets of Tranalyzer's flows;
	 * Separates SrcMacAddr from DstMacAddr and NumP 
	 */
	@Override
	public Flow beforeProcessingRawFlow(Flow f) {

		//Adds the calculated value of total size and number of packets
		f.add(calculateFlowNumPkt(f));
		f.add(calculateFlowSz(f));
		
		//Gets the SrcMacAddr_DstMacAddr_NumP all together and splits them
		StringTokenizer st = new StringTokenizer(f.get(12), "_");
		
		//Adds SrcMacAddr and DestMacAddr
		String srcMacAddr = st.nextElement().toString();
		f.add(srcMacAddr);
		String destMacAddr = st.nextElement().toString();
		f.add(destMacAddr);
		
		//Sets NumP alone where the whole content was
		String numP = st.nextElement().toString();
		f.set(12, numP);
		
		//int a = f.size();
		//System.out.println(a);
		return f;
	}

	public String calculateFlowSz(Flow f) {
		// 16 and 17 are the indexes of fwdSz and bwdSz
		Double flowSz = Double.valueOf(f.get(16)) + Double.valueOf(f.get(17));
		return flowSz.toString();
	}

	public String calculateFlowNumPkt(Flow f) {
		// 14 and 15 are the indexes of fwdNumPkt and bwdNumPkt
		Double flowNumPkt = Double.valueOf(f.get(14))
				+ Double.valueOf(f.get(15));
		return flowNumPkt.toString();
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
