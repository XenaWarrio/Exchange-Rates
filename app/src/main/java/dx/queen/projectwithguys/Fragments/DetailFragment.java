package dx.queen.projectwithguys.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dx.queen.projectwithguys.R;
import dx.queen.projectwithguys.Model.Value;

public class DetailFragment extends Fragment {
    TextView tvName;
    TextView tvBuy;
    TextView tvSale;
    public static final String CONSTANT_FOR_ARGUMENTS = "0";

    public static DetailFragment newInstance(int i) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(CONSTANT_FOR_ARGUMENTS, i);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int i = getArguments().getInt(CONSTANT_FOR_ARGUMENTS, 1);
            Value value = MainFragment.valuesList.get(i);
            fillviews(value);

        }
    }

    private void initViews(View v) {
        tvName = v.findViewById(R.id.name);
        tvBuy = v.findViewById(R.id.buy);
        tvSale = v.findViewById(R.id.sale);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_detail, container, false);
        initViews(v);
        return v;

    }


    private void fillviews(Value value) {
        tvName.setText(value.getValueName());
        tvBuy.setText(value.getCurrentBuy());
        tvSale.setText(value.getCurrentSale());
    }


}
