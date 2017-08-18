package com.java.study;

import de.tototec.cmdoption.CmdOption;

public class RedisConfig {
    @CmdOption(names = {"--help"}, description= "显示帮助", isHelp = true)
    public boolean help;

    @CmdOption(names = {"-h", "--host"}, args={"redisHost"}, description= "host")
    public String redisHost;

    @CmdOption(names = {"-p", "--port"}, args={"redisPort"}, description= "port")
    public String redisPort;

}
