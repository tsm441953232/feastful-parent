package com.tsm.redpacket.service;

import java.io.IOException;

public interface SerializeService {
    void serialize() throws IOException;

    void deserialize() throws IOException, ClassNotFoundException;
}
