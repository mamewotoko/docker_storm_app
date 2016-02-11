package com.mamewo.printapp;

import java.util.Map;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.topology.TopologyBuilder;

import backtype.storm.tuple.Fields;
import backtype.storm.task.TopologyContext;
import backtype.storm.spout.SpoutOutputCollector;

import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.Config;

import backtype.storm.utils.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// spout -> bolt(log)
public class PrintTopology {
    static
    public class PrinterBolt extends BaseBasicBolt {
	
	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector) {
	    System.out.println(tuple);
	    LOG.info("to logger: " + tuple);
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer ofd) {
	}
    }
    
    static
    public class IntSpout extends BaseRichSpout {
	SpoutOutputCollector collector_;
	private int currentInt_ = 0;
	
	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
	    collector_ = collector;
	    currentInt_ = 0;
	}

	@Override
	public void nextTuple() {
	    Utils.sleep(100);
	    collector_.emit(new Values(currentInt_++));
	}

	@Override
	public void ack(Object id) {
	}

	@Override
	public void fail(Object id) {
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	    declarer.declare(new Fields("int"));
	}
    }

    public static void main(String args[])
	throws Exception
    {
	TopologyBuilder builder = new TopologyBuilder();

	builder.setSpout("int_stream", new IntSpout(), 10);
	builder.setBolt("out", new PrinterBolt(), 3).shuffleGrouping("int_stream");

	Config conf = new Config();
	conf.setDebug(true);
	
	if (args != null && args.length > 0) {
	    conf.setNumWorkers(3);
	    
	    StormSubmitter.submitTopologyWithProgressBar(args[0], conf, builder.createTopology());
	}
	else {
	    LocalCluster cluster = new LocalCluster();
	    cluster.submitTopology("test", conf, builder.createTopology());
	    Utils.sleep(10000);
	    cluster.killTopology("test");
	    cluster.shutdown();
	}
    }

    static final
    private Logger LOG = LoggerFactory.getLogger(PrintTopology.class);
}
