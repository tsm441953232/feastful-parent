local maxSeqNumStr = redis.pcall("HGET", KEYS[1], "max")

if type(maxSeqNumStr) == 'boolean' and maxSeqNumStr == false
    then
	    return nil
    end
    local maxSeqNum = tonumber(maxSeqNumStr)
    local seqNum = redis.pcall("HINCRBY", KEYS[1], "cur", 1)
    if seqNum <= maxSeqNum then
    return seqNum..':'..maxSeqNum
    else
    return nil
    end