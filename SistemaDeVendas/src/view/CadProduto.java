/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CategoriaDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Categoria;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author Anderson
 */
public class CadProduto extends javax.swing.JFrame {

    CategoriaDAO categoriaDAO;
    FornecedorDAO fornecedorDAO;
    ProdutoDAO produtoDAO = new ProdutoDAO();
    Produto produto;
    ArrayList<Categoria> listCategoria = new ArrayList<>();
    ArrayList<Fornecedor> listFornecedor = new ArrayList<>();
    /**
     * Creates new form CadProduto
     */
    public CadProduto() {
        initComponents();
        categoriaDAO = new CategoriaDAO();
        fornecedorDAO = new FornecedorDAO();
        PreencherComboBox();
    }
    public void PreencherComboBox(){        
        listCategoria = categoriaDAO.mostrarCategorias();
        listFornecedor = fornecedorDAO.mostrarFornecedor();
        for(Categoria c : listCategoria){
            jComboBoxCategoria.addItem(c.getNome());
            
        }
        for(Fornecedor f : listFornecedor){
            jComboBoxFornecedor.addItem(f.getDescricao());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQuantidadeEmEstoque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Descriçao");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel2.setText("Quantidade em estoque");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(jTextFieldQuantidadeEmEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, -1));

        jLabel3.setText("Valor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        getContentPane().add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, -1));

        jComboBoxCategoria.setModel(jComboBoxCategoria.getModel());
        jComboBoxCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxCategoriaPopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 150, -1));

        getContentPane().add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 150, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        setSize(new java.awt.Dimension(416, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jComboBoxCategoriaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaPopupMenuWillBecomeVisible

    }//GEN-LAST:event_jComboBoxCategoriaPopupMenuWillBecomeVisible

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        Categoria categoria = new Categoria();
        for(Categoria c : listCategoria){
            if(c.getNome().equals(jComboBoxCategoria.getSelectedItem())){
                categoria = c;
            }            
        }
        for(Fornecedor f : listFornecedor){
            if(f.getDescricao().equals(jComboBoxFornecedor.getSelectedItem())){
                fornecedor = f;
            }
        }
        produto = new Produto(jTextFieldDescricao.getText(),Double.parseDouble( jTextFieldQuantidadeEmEstoque.getText()), Integer.parseInt(jTextFieldValor.getText()),fornecedor, categoria);
        produtoDAO.inserirProduto(produto);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldQuantidadeEmEstoque;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
