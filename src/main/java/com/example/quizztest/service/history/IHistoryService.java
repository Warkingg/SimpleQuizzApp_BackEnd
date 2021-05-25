package com.example.quizztest.service.history;

import com.example.quizztest.model.History;
import com.example.quizztest.service.IGeneralService;

public interface IHistoryService extends IGeneralService<History> {
    History addHistory(History history);

    History editHistory(History history, History history1);
}
