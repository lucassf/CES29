package com.mycompany.interfaces;

import com.mycompany.siapj1.Processo;


public interface IRepositorioProcessos {
	boolean addProcess(Processo processo);
	Processo getProcess(int id);
}
