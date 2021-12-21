package com.example.carssale.service;

import com.example.carssale.model.view.StatsView;

public interface StatsService {
    void onRequest();
    StatsView getStats();
}
