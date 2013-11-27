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
	public static final String flowIpMinTTl = "IpMinTTL";
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
	public static final String flowDestMacAddr = "DestMacAddr";
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
	public static final String flowDestAs = "DestAs";
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
	public static final String FlowDir = "Dir"; 	
	public static final String FlowInd = "FlowInd";
	public static final String FlowStat = "FlowStat";
	public static final String FlowUnixTimeFirst = "UnixTimeFirst";
	public static final String FlowUnixTimeLast = "UnixTimeLast";			
	public static final String FlowETHVlanID = "ETHVlanID";
	//TODO public static final String FlowSrcMac_DstMac_NumP = "SrcMac_DstMac_NumP";				
	public static final String FlowDstPortClass = "DstPort_class"; 						
	public static final String FlowPktps= "Pktps";
	public static final String FlowBytps= "Bytps";
	public static final String FlowPktAsm= "PktAsm";
	public static final String FlowBytAsm= "BytAsm";
	public static final String FlowIpMindIPID= "IpMindIPID";
	public static final String FlowIpTOS= "IpTOS"; 	
	public static final String FlowIpFlags= "IpFlags";
	public static final String FlowIpOptCnt= "IpOptCnt"; 
	public static final String FlowIpOptCpCl_Num = "IpOptCpCl_Num"; 	
	public static final String FlowTcpPSeqCnt = "TcpPSeqCnt";
	public static final String FlowTcpSeqSntBytes = "TcpSeqSntBytes";
	public static final String FlowTcpSeqFaultCnt = "TcpSeqFaultCnt";
	public static final String FlowTcpPAckCnt = "TcpPAckCnt"; 
	public static final String FlowTcpFlwLssAckRcvdBytes = "TcpFlwLssAckRcvdBytes"; 
	public static final String FlowTcpAckFaultCnt = "TcpAckFaultCnt";
	public static final String FlowTcpMinWinSz = "TcpMinWinSz";	
	public static final String FlowTcpWinSzUpCnt = "TcpWinSzUpCnt";
	public static final String FlowTcpWinSzChgDirCnt = "TcpWinSzChgDirCnt";
	public static final String FlowTcpAggrFlags = "TcpAggrFlags";
	public static final String FlowTcpAggrAnomaly = "TcpAggrAnomaly";
	public static final String FlowTcpOptPktCnt = "TcpOptPktCnt";
	public static final String FlowTcpOptCnt = "TcpOptCnt";
	public static final String FlowTcpAggrOptions = "TcpAggrOptions";
	public static final String FlowTcpMSS = "TcpMSS";
	public static final String FlowTcpWS = "TcpWS";
	public static final String FlowTcpSSA_SAATrip = "TcpSSA_SAATrip";
	public static final String FlowTcpRTTSseqAA = "TcpWinSzDwnCnt";
	public static final String FlowTcpRTTAckTripMin = "TcpRTTAckTripMin";
	public static final String FlowTcpRTTAckTripMax = "TcpRTTAckTripMax";
	public static final String FlowTcpRTTAckTripAve = "TcpRTTAckTripAve";
	public static final String FlowTcpStates = "TcpStates";
	public static final String FlowIcmpType_Code = "IcmpType_Code";
	public static final String FlowIcmpEchoSuccRatio = "IcmpEchoSuccRatio";
	public static final String FlowConnSrc = "ConnSrc";
	public static final String FlowConnDst = "ConnDst";
	public static final String FlowConnSrcDst = "ConnSrcDst";
	public static final String FlowMinPl = "MinPl";
	public static final String FlowMaxPl = "MaxPl";
	public static final String FlowMeanPl = "MeanPl";
	public static final String FlowLowQuartilePl = "LowQuartilePl";
	public static final String FlowMedianPl = "MedianPl";
	public static final String FlowUppQuartilePl = "UppQuartilePl";
	public static final String FlowIqdPl = "IqdPl";
	public static final String FlowModePl = "ModePl";
	public static final String FlowRangePl = "RangePl";
	public static final String FlowStdPl = "StdPl";
	public static final String FlowStdrobPl = "StdrobPl";
	public static final String FlowSkewPl = "SkewPl";
	public static final String FlowExcPl = "ExcPl";
	public static final String FlowLowQuartileIat = "LowQuartileIat";
	public static final String FlowUppQuartileIat = "UppQuartileIat";
	public static final String FlowIqdIat = "IqdIat";
	public static final String FlowModeIat = "ModeIat";
	public static final String FlowRobStdIat = "RobStdIat";
	public static final String FlowSkewIat = "SkewIat";
	public static final String FlowExcIat = "ExcIat";
	public static final String FlowL2L3L4Pl_Iat = "L2L3L4Pl_Iat";
	public static final String FlowPs_Iat_Cnt_PsCnt_IatCnt = "Ps_Iat_Cnt_PsCnt_IatCnt";

	
	private FeaturesConsts(){
		//this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	}
}
