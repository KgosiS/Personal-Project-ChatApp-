package com.example.sebakoempire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    private List<ChatMessage> messages;
    private Context context;

    public ChatAdapter(List<ChatMessage> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_message, parent, false);
            holder = new ViewHolder();
            holder.textViewMessage = view.findViewById(R.id.textViewMessage);
            holder.textViewTimestamp = view.findViewById(R.id.textViewTimestamp);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        ChatMessage message = messages.get(position);

        holder.textViewMessage.setText(message.getMessage());
        holder.textViewTimestamp.setText(message.getTimestamp());

        return view;
    }

    private static class ViewHolder {
        TextView textViewMessage;
        TextView textViewTimestamp;
    }
}