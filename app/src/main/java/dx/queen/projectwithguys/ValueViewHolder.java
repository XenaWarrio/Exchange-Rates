package dx.queen.projectwithguys;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import dx.queen.projectwithguys.Fragments.InterfaceForFragments;
import dx.queen.projectwithguys.Model.Value;

public class ValueViewHolder extends RecyclerView.ViewHolder {

    private TextView valueName;
    private TextView currentBuy;
    private TextView currentSale;

    public ValueViewHolder(@NonNull View itemView) {
        super(itemView);
        valueName = itemView.findViewById(R.id.value_name);
        currentBuy = itemView.findViewById(R.id.value_current_buy);
        currentSale = itemView.findViewById(R.id.value_current_sale);
    }

    public void bind(Value value , int n,InterfaceForFragments listener){
        valueName.setText(value.getValueName());
        currentBuy.setText(value.getBuy());
        currentSale.setText(value.getSale());
        listener.openDetailFragment(n);

    }
}
