/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import VO.Mesa;
import VO.Pedido;
import VO.Produto;
import controller.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author viniciuscustodio
 */
public class FormCardapio extends javax.swing.JFrame {

    public static FormCardapio cardapio = null;
    public ProdutoController produtoController = null;
    private Produto produtoSelecionado = null;
    private Pedido pedidoSelecionado = null;
    private List<Pedido> produtosPedido = new ArrayList();
    private List<Produto> produtos = null;
    private Mesa mesa;
    

    public static void createFormCardapio(Mesa mesaCliente) {
        if (cardapio == null) {
            cardapio = new FormCardapio();
        }
        cardapio.setVisible(true);
        cardapio.mesa = mesaCliente;
        cardapio.produtosPedido = new ArrayList();
        cardapio.fillTablePedidos();
        cardapio.fillTableProdutos();
    }

    public FormCardapio() {
        initComponents();
        this.produtoController = new ProdutoController();
    }

    private void fillTableProdutos() {
        produtos = this.produtoController.getProducts(mesa.getNomeCliente());
        DefaultTableModel model = (DefaultTableModel) this.jTableCardapio.getModel();
        model.setRowCount(0);

        produtos.stream().forEach((produto) -> {
            model.addRow(new Object[]{
                produto.getDescricao(), produto.getPreco()
            });
        });
    }

    private void fillTablePedidos(){
        DefaultTableModel model = (DefaultTableModel) this.jTablePedidos.getModel();
        model.setRowCount(0);
        produtosPedido.stream().forEach((pedido) -> {
            model.addRow(new Object[]{
                pedido.getProduto().getDescricao(), pedido.getProduto().getPreco(), pedido.getQuantidade()
            });
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCardapio = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jtAdicionar = new javax.swing.JButton();
        jtRemover = new javax.swing.JButton();
        jbFinalizarPedido = new javax.swing.JButton();
        jtQuantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cardápio"));

        jTableCardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCardapio.getTableHeader().setReorderingAllowed(false);
        jTableCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCardapioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCardapio);
        if (jTableCardapio.getColumnModel().getColumnCount() > 0) {
            jTableCardapio.getColumnModel().getColumn(0).setResizable(false);
            jTableCardapio.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pedido"));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePedidos);
        if (jTablePedidos.getColumnModel().getColumnCount() > 0) {
            jTablePedidos.getColumnModel().getColumn(0).setResizable(false);
            jTablePedidos.getColumnModel().getColumn(1).setResizable(false);
            jTablePedidos.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane2);

        jtAdicionar.setText("+");
        jtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAdicionarActionPerformed(evt);
            }
        });

        jtRemover.setText("-");
        jtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtRemoverActionPerformed(evt);
            }
        });

        jbFinalizarPedido.setText("Realizar Pedido");
        jbFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarPedidoActionPerformed(evt);
            }
        });

        jtQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtQuantidade.setText("1");
        jtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtQuantidadeActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade");

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbFinalizarPedido)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton1))
                                            .addComponent(jtRemover, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFinalizarPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Cardapio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAdicionarActionPerformed
        try {
            if (produtoSelecionado != null) {
                //System.out.println(produtoSelecionado.getDescricao());
                for (Pedido pedido : produtosPedido) {
                    if (pedido.getProduto().getDescricao().equals(produtoSelecionado.getDescricao())) {
                        if (jtQuantidade.getText().equals("")) {
                            pedido.setQuantidade(pedido.getQuantidade() + 1);
                        } else {
                            pedido.setQuantidade(pedido.getQuantidade() + Integer.parseInt(jtQuantidade.getText()));
                        }
                        return;
                    }
                }
                Pedido pedido = new Pedido();
                pedido.setProduto(produtoSelecionado);
                if (!jtQuantidade.getText().equals("")) {
                    pedido.setQuantidade(pedido.getQuantidade() + 1);
                } else {
                    pedido.setQuantidade(pedido.getQuantidade() + Integer.parseInt(jtQuantidade.getText()));
                }
                produtosPedido.add(pedido);
            }
        } finally {
            fillTablePedidos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAdicionarActionPerformed

    private void jtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtRemoverActionPerformed
        
        if(pedidoSelecionado != null){
            int valor = pedidoSelecionado.getQuantidade()- Integer.parseInt(jtQuantidade.getText());
            if( valor  <= 0 )
                produtosPedido.remove(pedidoSelecionado);
            else
                pedidoSelecionado.setQuantidade(valor);
        }
        fillTablePedidos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtRemoverActionPerformed

    private void jTableCardapioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCardapioMouseClicked
        produtoSelecionado = produtos.get(jTableCardapio.getSelectedRow());
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCardapioMouseClicked

    private void jtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtQuantidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            produtosPedido.remove(pedidoSelecionado);
        }finally{
            fillTablePedidos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePedidosMouseClicked
        pedidoSelecionado = produtosPedido.get(jTablePedidos.getSelectedRow());
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePedidosMouseClicked

    private void jbFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarPedidoActionPerformed
        if(!produtosPedido.isEmpty()){
            for(Pedido pedido : produtosPedido){
                Produto produto = pedido.getProduto();
                if(pedido.getQuantidade() > Integer.parseInt(produto.getQuantidade())){
                    JOptionPane.showMessageDialog(null, "Não foi possível realizar o pedido, quantidade desejada em falta.");
                    return;
                }
            }
            if(produtoController.realizarPedido(mesa.getNomeCliente(), produtosPedido)){
                FormMenu.menu.pedidoRealizado(produtosPedido);
                FormMenu.menu.setVisible(true);
                this.dispose();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbFinalizarPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCardapio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCardapio;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JButton jbFinalizarPedido;
    private javax.swing.JButton jtAdicionar;
    private javax.swing.JTextField jtQuantidade;
    private javax.swing.JButton jtRemover;
    // End of variables declaration//GEN-END:variables
}
