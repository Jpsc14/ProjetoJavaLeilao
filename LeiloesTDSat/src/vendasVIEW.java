/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class vendasVIEW extends JFrame {

    private JTable table;

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        listarProdutosVendidos();
    }

    private void listarProdutosVendidos() {
        ProdutosDAO produtodao = new ProdutosDAO();
        List<ProdutosDTO> produtos = produtodao.listarProdutosVendidos();
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Status"}, 0);
        for (ProdutosDTO produto : produtos) {
            model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getValor(), produto.getStatus()});
        }
        table.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            vendasVIEW view = new vendasVIEW();
            view.setVisible(true);
        });
    }
}