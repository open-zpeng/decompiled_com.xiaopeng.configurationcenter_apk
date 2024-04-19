package com.b.a.j.a;

import com.b.a.i.d;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
/* compiled from: ProgressRequestBody.java */
/* loaded from: classes.dex */
public class c<T> extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private RequestBody f1269a;
    private com.b.a.c.b<T> b;
    private b c;

    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(com.b.a.i.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RequestBody requestBody, com.b.a.c.b<T> bVar) {
        this.f1269a = requestBody;
        this.b = bVar;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f1269a.contentType();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.f1269a.contentLength();
        } catch (IOException e) {
            com.b.a.k.d.a(e);
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new a(bufferedSink));
        this.f1269a.writeTo(buffer);
        buffer.flush();
    }

    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes.dex */
    private final class a extends ForwardingSink {
        private com.b.a.i.d b;

        a(Sink sink) {
            super(sink);
            com.b.a.i.d dVar = new com.b.a.i.d();
            this.b = dVar;
            dVar.g = c.this.contentLength();
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            com.b.a.i.d.a(this.b, j, new d.a() { // from class: com.b.a.j.a.c.a.1
                @Override // com.b.a.i.d.a
                public void a(com.b.a.i.d dVar) {
                    if (c.this.c != null) {
                        c.this.c.a(dVar);
                    } else {
                        c.this.a(dVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.b.a.i.d dVar) {
        com.b.a.k.b.a(new Runnable() { // from class: com.b.a.j.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.b != null) {
                    c.this.b.uploadProgress(dVar);
                }
            }
        });
    }

    public void a(b bVar) {
        this.c = bVar;
    }
}
