package com.example.quizztest.service.history;

import com.example.quizztest.dto.HistoryDto;

import java.util.List;

public interface IHistoryManager {
    HistoryDto addHistory(HistoryDto historyDto);

    List<HistoryDto> getHistories();

    HistoryDto findHistoryBySore(int score);

    HistoryDto findHistoryByUsername(String username);

    HistoryDto editHistory(HistoryDto historyDto, String username);
}
