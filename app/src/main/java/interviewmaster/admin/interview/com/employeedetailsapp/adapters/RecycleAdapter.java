package interviewmaster.admin.interview.com.employeedetailsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import interviewmaster.admin.interview.com.employeedetailsapp.R;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Employee;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyviewHolder> {
    List<Example> mexamples;
    Context mContext;
    LayoutInflater inflater;
    Clicklistner clicklistner;

    public RecycleAdapter(Context context, List<Example> examples) {
        this.mContext = context;
        this.mexamples = examples;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.employeecontent, parent, false);
        return new MyviewHolder(view);
    }

    public void setClicklistner(Clicklistner clicklistner) {
        this.clicklistner = clicklistner;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        Employee employee = mexamples.get(0).getEmployee().get(position);
        holder.textname.setText(employee.getFirstName());
        holder.textdistrict.setText(employee.getCity());
        Glide.with(mContext).load(employee.getImageURL()).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        if (mexamples.get(0).getEmployee().size() == 0) {
            return 0;
        } else {
            return mexamples.get(0).getEmployee().size();
        }
    }


    class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.employeeimage)
        ImageView imageView;
        @BindView(R.id.employeename)
        TextView textname;
        @BindView(R.id.employeedistrict)
        TextView textdistrict;

        public MyviewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Employee employee = mexamples.get(0).getEmployee().get(position);
            clicklistner.clicked(employee.getFirstName());
        }
    }

    public interface Clicklistner {

        void clicked(String name);
    }
}
