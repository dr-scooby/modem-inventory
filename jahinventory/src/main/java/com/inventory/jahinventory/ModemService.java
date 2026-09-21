package com.inventory.jahinventory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModemService {

    private final ModemsRepository modemsRepository;

    public ModemService(ModemsRepository modemsRepository) {
        this.modemsRepository = modemsRepository;
    }


    // add a new modem to the inventory DB
    public void addModem(Modems mods){
        modemsRepository.save(mods);
    }

    // get All modems from the DB
    public List<Modems> getAllModems(){

        return modemsRepository.findAll();
    }
}
