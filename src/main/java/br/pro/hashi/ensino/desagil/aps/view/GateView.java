// FONTE DAS IMAGENS: https://en.wikipedia.org/wiki/Logic_gate (domínio público)

package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GateView extends JPanel implements ActionListener {

    private final Gate gate;

    private final JCheckBox inputA;
    private final JCheckBox inputB;
    private final Switch SWA;
    private final Switch SWB;
    private final JCheckBox output;

    public GateView(Gate gate) {
        this.gate = gate;

        inputA = new JCheckBox();
        inputB = new JCheckBox();
        SWA = new Switch();
        SWB = new Switch();
        output = new JCheckBox();

        JLabel LinputA = new JLabel("Entrada A");
        JLabel LinputB = new JLabel("Entrada B");
        JLabel Loutput = new JLabel("Saída");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (gate.getInputSize() == 2) {
            add(LinputA);
            add(inputA);

            add(LinputB);
            add(inputB);
        } else {
            add(LinputA);
            add(inputA);
        }
        add(Loutput);
        add(output);

        inputA.addActionListener(this);
        inputB.addActionListener(this);

        output.setEnabled(false);


        update();
    }

    private void update() {

        if (inputA.isSelected()) {
            SWA.turnOn();
        }
        if (inputB.isSelected()) {
            SWB.turnOn();
        }
        if (gate.getInputSize() == 2) {
            gate.connect(0, SWA);
            gate.connect(1, SWB);
        } else {
            gate.connect(0, SWA);
        }
        output.setSelected(gate.read());

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }
}

