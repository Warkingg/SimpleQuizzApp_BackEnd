package com.example.quizztest.service.history;

import com.example.quizztest.dto.HistoryDto;
import com.example.quizztest.model.History;
import com.example.quizztest.model.OrikaBeanMapper;
import com.example.quizztest.repository.IHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HistoryManager implements IHistoryManager {
    private OrikaBeanMapper orikaBeanMapper;

    private IHistoryRepository historyRepository;

    private IHistoryService historyService;

    @Autowired
    public HistoryManager(OrikaBeanMapper orikaBeanMapper,IHistoryRepository historyRepository, IHistoryService historyService){
        this.orikaBeanMapper = orikaBeanMapper;
        this.historyRepository = historyRepository;
        this.historyService = historyService;
    }
    @Override
    public HistoryDto addHistory(HistoryDto historyDto) {
        History history = orikaBeanMapper.map(historyRepository,History.class);
        return orikaBeanMapper.convertDTO(historyService.addHistory(history),HistoryDto.class);
    }

    @Override
    public List<HistoryDto> getHistories() {
        List<History> histories = historyRepository.findAll();
        histories.sort((f1,f2) -> Long.compare(f2.getSore(),f1.getSore()));
        return orikaBeanMapper.convertListDTO(histories,HistoryDto.class);
    }

    @Override
    public HistoryDto findHistoryBySore(int score) {
        return orikaBeanMapper.convertDTO(historyRepository.findHistoryBySore(score),HistoryDto.class);
    }

    @Override
    public HistoryDto findHistoryByUsername(String username) {
        return orikaBeanMapper.convertDTO(historyRepository.findHistoryByUsername(username), HistoryDto.class);
    }

    @Override
    public HistoryDto editHistory(HistoryDto historyDto, String username) {
        History history = orikaBeanMapper.map(historyDto, History.class);
        History history1 = historyRepository.findHistoryByUsername(username);
        return orikaBeanMapper.convertDTO(historyService.editHistory(history,history1), HistoryDto.class);
    }
}
