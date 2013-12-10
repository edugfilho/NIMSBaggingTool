package main;

import com.beust.jcommander.Parameter;

public class Parameters {

	/**
	 * Parameters used in the CUI. Reference:
	 * http://beust.com/jcommander/#Parameter_validation
	 */

	@Parameter(names = {"-pcap", "-l1", "L1"}, description = "Start processing from .pcap file (must specify a tool)")
	public Boolean startFromPcap = false;
	
	@Parameter(names = {"-processed", "-l3", "-L3" }, description = "Start the process from a previously processed file")
	public Boolean fileProcessed = false;

	@Parameter(names = { "-netmate", "-net" }, description = "Use Netmate tool for processing")
	public Boolean useNetmate = false;

	@Parameter(names = { "-softflowd", "-soft" }, description = "Use Softflowd tool for processing")
	public Boolean useSoftflowd = false;

	@Parameter(names = { "-tranalyzer", "-tran" }, description = "Use Tranalyzer tool for processing")
	public Boolean useTranalyzer = false;

	@Parameter(names = "-yaf", description = "Use Yaf tool for processing")
	public Boolean useYaf = false;

	@Parameter(names = { "-i", "-input" }, description = "Complete path of the file to be processed", required = true)
	public String filePath;

	@Parameter(names = "--help", help = true)
	public boolean help;
}
