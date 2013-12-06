package bagging.feature;

public class FeaturesConsts {
	public static final String flowSrcIpAddr = "SrcIpAddr";
	public static final String flowDstIpAddr = "DstIpAddr";
	public static final String flowSrcPort = "SrcPort";
	public static final String flowDstPort = "DstPort";
	public static final String flowProtocol = "Protocol";
	
	//TRANALYZER BASED FEATURES
	public static final String flowDuration = "FlowDur";
	public static final String flowNumPkt = "NumOfPkts";
	public static final String flowSz = "FlowSz";
	public static final String flowMinPktSz = "MinPktSize";
	public static final String flowMaxPktSz = "MaxPktSz";
	public static final String flowAvgPktSz = "AvgPktSz";
	public static final String flowIpMinTTL = "IpMinTTL";
	public static final String flowIpMaxTTL = "IpMaxTTL";
	public static final String flowIpTTLChg = "IPTTLChg";
	public static final String flowTcpInitWinSz ="TcpInitWinSz";
	public static final String flowTcpAvgWinSz = "AvgWinSz";
	public static final String flowTcpMinWinSz = "TcpMinWinSz";
	public static final String flowTcpMaxWinSz = "TcpMaxWinSz";
	public static final String flowMinIAT = "MinIAT";
	public static final String flowMaxIAT = "MaxIAT";
	public static final String flowMeanIAT = "MeanIAT";
	public static final String flowMedianIAT = "MedianIAT";
	public static final String flowRangeIAT = "RangeIAT";
	public static final String flowStdIAT = "StdIAT";
	
	//NETMATE BASED FEATURES
	public static final String flowTotalFwdPkt = "TotalFwdPkts";
	public static final String flowTotalFwdSz = "TotalFwdSz";
	public static final String flowTotalBwdPkt = "TotalBwdPkts";
	public static final String flowTotalBwdSz = "TotalBwdSz";
	public static final String flowMinFwdPktSz = "MinFwdPktSz";
	public static final String flowMaxFwdPktSz = "MaxFwdPktSz";
	public static final String flowMeanFwdPktSz = "MeanFwdPktSz";
	public static final String flowStdFwdPktSz = "StdFwdPktSz";
	public static final String flowMinBwdPktSz = "MinBwdPktSz";
	public static final String flowMaxBwdPktSz = "MaxBwdPktSz";
	public static final String flowMeanBwdPktSz = "MeanBwdPktSz";
	public static final String flowStdBwdPktSz = "StdBwdPktSz";
	public static final String flowMinFIAT = "MinFIAT";
	public static final String flowMeanFIAT = "MeanFIAT";
	public static final String flowMaxFIAT ="MaxFIAT";
	public static final String flowStdFIAT = "StdFIAT";
	public static final String flowMinBIAT = "MinBIAT";
	public static final String flowMeanBIAT = "MeanBIAT";
	public static final String flowMaxBIAT = "MaxBIAT";
	public static final String flowStdBIAT = "StdBIAT";
	public static final String flowMinActive = "MinActive";
	public static final String flowMaxActive = "MaxActive";
	public static final String flowMeanActive = "MeanActive";
	public static final String flowStdActive = "StdActive";
	public static final String flowMinIdle = "MinIdle";
	public static final String flowMaxIdle = "MaxIdle";
	public static final String flowStdIdle = "StdIdle";
	public static final String flowSubflowAvgNumFwdPkt = "SubFlowAvgNumFwdPkt";
	public static final String flowSubFlowAvgFwdSz ="SubFlowAvgFwdSz";
	public static final String flowSubflowAvgNumBwdPkt = "SubFlowAvgNumBwdPkt";
	public static final String flowSubFlowAvgBwdSz ="SubFlowAvgBwdSz";
	public static final String flowHeaderFwdTotalSz = "HeaderTotalFwdSz";
	public static final String flowHeaderBwdTotalSz = "HeaderTotalBwdSz";
	
	//NOT USED NETMATE FEATURES
	public static final String flowPshFwdCount = "PshFwdCount";
	public static final String flowPshBwdCount = "PshBwdCount";
	public static final String flowUrgFwdCount = "UrgFwdCount";
	public static final String flowUrgBwdCount = "UrgBwdCount";

	//SOFTFLOWD BASED FEATURES 
	public static final String flowBytesPerSec = "BytesPerSec";
	public static final String flowPktPerSec = "PktPerSec";
	public static final String flowBytesPerPkt = "BytesPerPkt";
	//YAF BASED FEATURES 
	public static final String flowReverseFlowDeltaMiliseconds = "ReverseFlowDeltaMiliseconds";
    
	//NOT USED YAF FEATURES
	public static final String flowStartTime = "StartTime";
	public static final String flowEndTime = "EndTime";
	public static final String flowRtt = "Rtt";
	public static final String flowSrcMacAddr = "SrcMacAddr";
	public static final String flowDstMacAddr = "DstMacAddr";
	public static final String flowFwdIflags = "FwdIflags";
	public static final String flowBwdIflags = "BwdIflags";
	public static final String flowFwdUflags = "FwdUflags";
	public static final String flowBwdUflags = "BwdUflags";
	public static final String flowFwdIsn = "FwdIsn";
	public static final String flowBwdIsn = "BwdIsn";
	public static final String flowFwdTag = "FwdTag";
	public static final String flowBwdTag = "BwdTag";
	public static final String flowAppLabel = "AppLabel";
	public static final String flowEndReason = "EndReason";

	//NOT USED SOFTFLOWD FEATURES
	public static final String flowNextHopIp = "NextHopIp";
	public static final String flowBGPNextHopIp = "BGPNextHopIp";
	public static final String flowRouterIp = "RouterIp";
	public static final String flowSrcAs = "SrcAs";
	public static final String flowDstAs = "DstAs";
	public static final String flowInput = "Input";
	public static final String flowOutput = "Output";
	public static final String flowFlows = "Flows";
	public static final String flowTos = "Tos";
	public static final String flowSTos = "STos";
	public static final String flowDTos = "DTos";
	public static final String flowDir = "Dir";
	public static final String flowSmask = "Smask";
	public static final String flowDmask = "Dmask";
	public static final String flowFwd = "Fwd";
	public static final String flowSVLan = "SVLan";
	public static final String flowDVLan = "DVLan";
	public static final String flowEngine = "Engine";
	
	//NOT USED TRANALYZER FEATURES
	public static final String flowInd = "FlowInd";
	public static final String flowStat = "FlowStat";
	public static final String flowUnixTimeFirst = "UnixTimeFirst";
	public static final String flowUnixTimeLast = "UnixTimeLast";			
	public static final String flowETHVlanID = "ETHVlanID";
	public static final String flowNumP = "NumP";				
	public static final String flowDstPortClass = "DstPort_class"; 						
	public static final String flowPktps = "Pktps";
	public static final String flowBytps = "Bytps";
	public static final String flowPktAsm = "PktAsm";
	public static final String flowBytAsm = "BytAsm";
	public static final String flowIpMindIPID = "IpMindIPID";
	public static final String flowIpMaxdIPID = "IpMaxdIPID";
	public static final String flowTcpWinSzDwnCnt = "TcpWinSzDwnCnt";
	public static final String flowIpTOS= "IpTOS"; 	
	public static final String flowIpFlags= "IpFlags";
	public static final String flowIpOptCnt= "IpOptCnt"; 
	public static final String flowIpOptCpCl_Num = "IpOptCpCl_Num"; 	
	public static final String flowTcpPSeqCnt = "TcpPSeqCnt";
	public static final String flowTcpSeqSntBytes = "TcpSeqSntBytes";
	public static final String flowTcpSeqFaultCnt = "TcpSeqFaultCnt";
	public static final String flowTcpPAckCnt = "TcpPAckCnt"; 
	public static final String flowTcpFlwLssAckRcvdBytes = "TcpFlwLssAckRcvdBytes"; 
	public static final String flowTcpAckFaultCnt = "TcpAckFaultCnt";
	public static final String flowTcpWinSzUpCnt = "TcpWinSzUpCnt";
	public static final String flowTcpWinSzChgDirCnt = "TcpWinSzChgDirCnt";
	public static final String flowTcpAggrFlags = "TcpAggrFlags";
	public static final String flowTcpAggrAnomaly = "TcpAggrAnomaly";
	public static final String flowTcpOptPktCnt = "TcpOptPktCnt";
	public static final String flowTcpOptCnt = "TcpOptCnt";
	public static final String flowTcpAggrOptions = "TcpAggrOptions";
	public static final String flowTcpMSS = "TcpMSS";
	public static final String flowTcpWS = "TcpWS";
	public static final String flowTcpSSA_SAATrip = "TcpSSA_SAATrip";
	public static final String flowTcpRTTSseqAA = "TcpWinRTTSseqAA";
	public static final String flowTcpRTTAckTripMin = "TcpRTTAckTripMin";
	public static final String flowTcpRTTAckTripMax = "TcpRTTAckTripMax";
	public static final String flowTcpRTTAckTripAve = "TcpRTTAckTripAve";
	public static final String flowTcpStates = "TcpStates";
	public static final String flowIcmpType_Code = "IcmpType_Code";
	public static final String flowIcmpEchoSuccRatio = "IcmpEchoSuccRatio";
	public static final String flowConnSrc = "ConnSrc";
	public static final String flowConnDst = "ConnDst";
	public static final String flowConnSrcDst = "ConnSrcDst";
	public static final String flowMinPl = "MinPl";
	public static final String flowMaxPl = "MaxPl";
	public static final String flowMeanPl = "MeanPl";
	public static final String flowLowQuartilePl = "LowQuartilePl";
	public static final String flowMedianPl = "MedianPl";
	public static final String flowUppQuartilePl = "UppQuartilePl";
	public static final String flowIqdPl = "IqdPl";
	public static final String flowModePl = "ModePl";
	public static final String flowRangePl = "RangePl";
	public static final String flowStdPl = "StdPl";
	public static final String flowStdrobPl = "StdrobPl";
	public static final String flowSkewPl = "SkewPl";
	public static final String flowExcPl = "ExcPl";
	public static final String flowLowQuartileIat = "LowQuartileIat";
	public static final String flowUppQuartileIat = "UppQuartileIat";
	public static final String flowIqdIat = "IqdIat";
	public static final String flowModeIat = "ModeIat";
	public static final String flowRobStdIat = "RobStdIat";
	public static final String flowSkewIat = "SkewIat";
	public static final String flowExcIat = "ExcIat";
	public static final String flowL2L3L4Pl_Iat = "L2L3L4Pl_Iat";
	public static final String flowPs_Iat_Cnt_PsCnt_IatCnt = "Ps_Iat_Cnt_PsCnt_IatCnt";

	
	private FeaturesConsts(){
		//this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	}
}
