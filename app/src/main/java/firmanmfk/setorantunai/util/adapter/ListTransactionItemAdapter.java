package firmanmfk.setorantunai.util.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.model.data.Transaction;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public abstract class ListTransactionItemAdapter extends RecyclerView.Adapter<ListTransactionItemAdapter.TransactionItemHolder> {

    private List<Transaction> transactions;
    private Context context;
    private View itemView;

    class TransactionItemHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_id_setoran)
        TextView tvIdSetoran;
        @Bind(R.id.tv_id_invoice)
        TextView tvIdInvoice;
        @Bind(R.id.tv_jumlah)
        TextView tvJumlah;
        @Bind(R.id.tv_kantor)
        TextView tvKantor;
        @Bind(R.id.tv_no_rekening)
        TextView tvNoRekening;

        public TransactionItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public ListTransactionItemAdapter(Context context, List<Transaction> transactions) {
        this.transactions = transactions;
        this.context = context;
    }

    @Override
    public TransactionItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tranksaksi, parent, false);

        return new TransactionItemHolder(itemView);
    }

    public abstract void onItemClick(int position);

    @Override
    public void onBindViewHolder(TransactionItemHolder holder, final int position) {
        Transaction item = transactions.get(position);

        holder.tvIdInvoice.setText(context.getString(R.string.id_invoice) + " : " + item.getIdInvoice());
        holder.tvIdSetoran.setText(context.getString(R.string.id_setoran) + " : " + item.getIdSetoran());
        holder.tvJumlah.setText(context.getString(R.string.jumlah) + " : " +
                String.valueOf(Integer.parseInt(item.getTotalBiaya())));
        holder.tvKantor.setText(context.getString(R.string.kantor) + " : " + item.getKantor());
        holder.tvNoRekening.setText(context.getString(R.string.no_rekening) + " : " + item.getNoRekening());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }
}