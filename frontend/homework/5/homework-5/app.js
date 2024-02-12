const hhtp = require('http');
const fs = require('fs');
const os = require('os');
const path = require('path');
const process = require('process');
const { execSync } = require('child_process');

function systemInfo(){
    return {
        HostName: os.hostname(),
        OperatingSystem: os.platform(),
        Architecture: os.arch(),
        OSRelease: os.release(),
        Uptime: os.uptime(),
        NumCPUCores: os.cpus().length,
        TotalMemory: (os.totalmem() / (1024 ** 3)).toFixed(2), 
        FreeMemory: (os.freemem() / (1024 ** 3)).toFixed(2),
        CurrentWorkingDirectory: process.cwd(),
    };
}

function jsonTofile(data, filename='systeminfo.json'){
    fs.writeFileSync(filename, JSON.stringify(data,null,4));
}

const systemInfofile = systemInfo();;
jsonTofile(systemInfofile);