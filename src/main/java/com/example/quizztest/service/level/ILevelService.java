package com.example.quizztest.service.level;

import com.example.quizztest.model.Level;
import com.example.quizztest.model.Theme;
import com.example.quizztest.service.IGeneralService;


public interface ILevelService extends IGeneralService <Level> {

    Level addLevel(Level level, Theme theme);

}
