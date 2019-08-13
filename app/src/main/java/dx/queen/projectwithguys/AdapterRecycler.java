package dx.queen.projectwithguys;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dx.queen.projectwithguys.Model.Value;

public class AdapterRecycler extends RecyclerView.Adapter<ValueViewHolder> {

    List<Value> valueList;

    @NonNull
    @Override
    public ValueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model,viewGroup,false);
        return new ValueViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ValueViewHolder valueViewHolder, int i) {
        valueViewHolder.bind(i);

    }

    @Override
    public int getItemCount() {
        return valueList.size();
    }
}
